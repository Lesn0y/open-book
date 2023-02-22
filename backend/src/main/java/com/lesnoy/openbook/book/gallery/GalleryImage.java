package com.lesnoy.openbook.book.gallery;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_gallery", schema = "open_book")
public class GalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "image_url")
    private String imageUrl;

    public GalleryImage(int bookId, String imageUrl) {
        this.bookId = bookId;
        this.imageUrl = imageUrl;
    }
}
