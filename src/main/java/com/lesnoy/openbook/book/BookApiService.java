package com.lesnoy.openbook.book;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final BookParser parser;

    public BookApiService(BookParser parser) {
        this.parser = parser;
    }

    public List<Book> findBookByText(String text) {
        String responseJson = restTemplate.getForObject(
                "https://www.googleapis.com/books/v1/volumes?filter=ebooks&q=" + text,
                String.class);
        return parser.bookParse(responseJson);
    }

    public List<Book> findBooksByTitle(String title) {
        String responseJson = restTemplate.getForObject(
                "https://www.googleapis.com/books/v1/volumes?filter=ebooks&q=intitle:" + title,
                String.class);
        return parser.bookParse(responseJson);
    }

    public List<Book> findBookByAuthor(String author) {
        String responseJson = restTemplate.getForObject(
                "https://www.googleapis.com/books/v1/volumes?filter=ebooks&q=inauthor:" + author,
                String.class);
        return parser.bookParse(responseJson);
    }
}
