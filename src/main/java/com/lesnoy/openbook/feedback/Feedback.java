package com.lesnoy.openbook.feedback;

import com.lesnoy.openbook.book.Book;
import com.lesnoy.openbook.book.UserBookPKId;
import com.lesnoy.openbook.user.User;
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
@IdClass(UserBookPKId.class)
@Table(name = "feedback", schema = "open_book")
public class Feedback {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "review")
    private String review;
    @Column(name = "rating")
    private long rating;
}
