package com.lesnoy.openbook.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book getById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found with id " + id));
    }

    @Transactional
    public Page<List<Book>> getAll(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    @Transactional
    public Page<List<Book>> getBookByGenre(Integer genre, int page, int size) {
        return bookRepository.findAllByGenreId(genre, PageRequest.of(page, size));
    }
}
