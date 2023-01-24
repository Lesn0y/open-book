package com.lesnoy.openbook.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookParser {

    private final ObjectMapper mapper;

    public BookParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Book> bookParse(String json) {
        try {
            List<Book> books = new ArrayList<>();

            JsonNode items = mapper.readTree(json).get("items");

            for (JsonNode item : items) {
                JsonNode bookVolume = item.get("volumeInfo");
                JsonNode imageLinks = bookVolume.get("imageLinks");

                Book book = new Book(
                        item.get("id").asText(),
                        bookVolume.get("title").asText(),
                        "None",
                        imageLinks.get("thumbnail").asText());

                if (bookVolume.has("authors")) {
                    book.setAuthors(bookVolume.get("authors").toString());
                }

                books.add(book);
            }

            return books;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
