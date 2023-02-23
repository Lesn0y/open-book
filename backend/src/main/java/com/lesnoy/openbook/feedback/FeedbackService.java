package com.lesnoy.openbook.feedback;

import com.lesnoy.openbook.book.Book;
import com.lesnoy.openbook.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final BookService bookService;

    public Feedback save(int bookId, Feedback feedback) {
        Book book = bookService.getById(bookId);
        return feedbackRepository.save(new Feedback(
                feedback.getUser(),
                book,
                feedback.getReview(),
                feedback.getRating()
        ));
    }
}
