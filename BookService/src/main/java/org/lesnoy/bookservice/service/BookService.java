package org.lesnoy.bookservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lesnoy.bookservice.dao.BookRepository;
import org.lesnoy.bookservice.dto.BookRequest;
import org.lesnoy.bookservice.exceptions.BookNotFoundException;
import org.lesnoy.bookservice.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository repository;

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooksInStock(boolean inStock) {
        return repository.findBooksByInStock(inStock);
    }

    @Transactional
    public List<Book> checkBookInStock(List<Long> itemsId) {
        return repository.findByIdInAndInStockTrue(itemsId);
    }

    @Transactional(readOnly = true)
    public Book getBookById(long id) throws BookNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id=" + id + " was not found"));
    }

    @Transactional
    public Book saveBook(BookRequest bookDTO) {
        Book book = repository.save(new Book(
                bookDTO.getName(),
                bookDTO.getAuthor(),
                bookDTO.getDescription()));
        log.info("Book '" + book.getName() + "' was saved with id=" + book.getId());
        return book;
    }

    @Transactional
    public Book updateBook(long id, BookRequest bookDTO) throws BookNotFoundException {
        Book oldBook = getBookById(id);
        oldBook.setName(bookDTO.getName());
        oldBook.setAuthor(bookDTO.getAuthor());
        oldBook.setDescription(bookDTO.getDescription());
        log.info("Book " + oldBook.getName() + "/" + id + " was updated, new value - " +
                "{'" + oldBook.getName() + "', '" + oldBook.getAuthor() + "', " + oldBook.getDescription() + "'}");
        return oldBook;
    }

    @Transactional
    public Book changeStateInStock(long id) throws BookNotFoundException {
        Book book = getBookById(id);
        book.setInStock(!book.isInStock());
        log.info("Now book " + book.getName() + "/" + id + " in stock=" + book.isInStock());
        return book;
    }

    @Transactional
    public void deleteBookById(long id) throws BookNotFoundException {
        Book book = getBookById(id);
        repository.delete(book);
        log.info("Book " + book.getName() + "/" + id + " was deleted");
    }
}
