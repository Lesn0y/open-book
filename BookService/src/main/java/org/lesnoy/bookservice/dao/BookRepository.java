package org.lesnoy.bookservice.dao;

import org.lesnoy.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByInStock(boolean inStock);

    List<Book> findByIdInAndInStockTrue(List<Long> itemsId);
}
