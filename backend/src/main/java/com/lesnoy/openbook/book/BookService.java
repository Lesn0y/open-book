package com.lesnoy.openbook.book;

import com.lesnoy.openbook.book.author.Author;
import com.lesnoy.openbook.book.author.AuthorRepository;
import com.lesnoy.openbook.book.dto.PostBookRequest;
import com.lesnoy.openbook.book.genre.Genre;
import com.lesnoy.openbook.book.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Transactional
    public Book save(PostBookRequest bookDto) {
        Author author = authorRepository.findByFullName(bookDto.getAuthor());
        if (author == null) {
            author = authorRepository.save(new Author(bookDto.getAuthor()));
        }
        List<Genre> genres = new ArrayList<>();
        bookDto.getGenres().forEach(el -> {
            Genre genre = genreRepository.findByName(el);
            genres.add(Objects.requireNonNullElseGet(genre,
                    () -> genreRepository.save(new Genre(el))));
        });
        Book book = new Book(
                bookDto.getThumbnailUrl(),
                bookDto.getBookName(),
                author,
                bookDto.getPageCount(),
                bookDto.getSubtitle(),
                genres,
                bookDto.getDescription()
        );
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
