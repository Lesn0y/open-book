package org.lesnoy.inventoryservice.dao;

import org.lesnoy.inventoryservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByInStock(boolean inStock);

}
