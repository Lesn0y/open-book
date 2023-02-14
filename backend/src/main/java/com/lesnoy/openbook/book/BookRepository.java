package com.lesnoy.openbook.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT b.id, b.thumbnail_url, b.book_name, " +
            "       b.author_id, b.pagecount, b.subtitle, " +
            "       b.description, g.genre_name " +
            "FROM open_book.book_genre " +
            "INNER JOIN open_book.book b on b.id = open_book.book_genre.book_id " +
            "INNER JOIN open_book.genre g on g.id = open_book.book_genre.genre_id " +
            "WHERE g.id = :genre",
            nativeQuery = true)
    Page<List<Book>> findAllByGenreId(@Param("genre") Integer genre, Pageable pageable);

    Page<List<Book>> findAll(Pageable pageable);
}
