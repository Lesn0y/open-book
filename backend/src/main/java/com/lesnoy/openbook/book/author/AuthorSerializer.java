package com.lesnoy.openbook.book.author;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lesnoy.openbook.book.Book;

import java.io.IOException;

public class AuthorSerializer extends StdSerializer<Author> {

    public AuthorSerializer() {
        this(null);
    }

    public AuthorSerializer(Class<Author> t) {
        super(t);
    }

    @Override
    public void serialize(Author value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("full_name", value.getFullName());
        gen.writeArrayFieldStart("books");
        for (Book book : value.getBooks()) {
            gen.writeStartObject();
            gen.writeNumberField("id", book.getId());
            gen.writeStringField("thumbnail_url", book.getThumbnailUrl());
            gen.writeStringField("book_name", book.getName());
            gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
