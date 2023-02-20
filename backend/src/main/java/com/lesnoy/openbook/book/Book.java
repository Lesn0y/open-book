package com.lesnoy.openbook.book;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lesnoy.openbook.book.author.Author;
import com.lesnoy.openbook.book.gallery.GalleryImage;
import com.lesnoy.openbook.book.genre.Genre;
import com.lesnoy.openbook.feedback.Feedback;
import com.lesnoy.openbook.history.History;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = BookSerializer.class)
@Entity
@Table(name = "book", schema = "open_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    @Column(name = "book_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "pagecount")
    private int pageCount;
    @Column(name = "subtitle")
    private String subtitle;
    @ManyToMany
    @JoinTable(name = "book_genre", schema = "open_book",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<History> history;
    @OneToMany
    @JoinColumn(name = "book_id")
    private List<GalleryImage> galleryImage;
}


