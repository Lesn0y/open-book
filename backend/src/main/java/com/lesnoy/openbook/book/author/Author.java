package com.lesnoy.openbook.author;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lesnoy.openbook.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = AuthorSerializer.class)
@Entity
@Table(name = "author", schema = "open_book")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;
}
