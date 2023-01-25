package com.lesnoy.openbook.history;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lesnoy.openbook.book.Book;
import com.lesnoy.openbook.book.UserBookPKId;
import com.lesnoy.openbook.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = HistorySerializer.class)
@Entity
@Table(name = "history", schema = "open_book")
@IdClass(UserBookPKId.class)
public class History {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "date_issue")
    private Timestamp dateIssue;
    @Column(name = "date_return")
    private Timestamp dateReturn;
}
