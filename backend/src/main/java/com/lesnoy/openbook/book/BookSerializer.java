package com.lesnoy.openbook.book;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lesnoy.openbook.feedback.Feedback;
import com.lesnoy.openbook.history.History;

import java.io.IOException;

public class BookSerializer extends StdSerializer<Book> {

    public BookSerializer() {
        this(null);
    }

    public BookSerializer(Class<Book> t) {
        super(t);
    }

    @Override
    public void serialize(Book value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("thumbnail_url", value.getThumbnailUrl());
        gen.writeStringField("book_name", value.getName());
        gen.writeObjectFieldStart("author");
            gen.writeNumberField("id", value.getAuthor().getId());
            gen.writeStringField("full_name", value.getAuthor().getFullName());
        gen.writeEndObject();
        if (!value.getFeedbacks().isEmpty()) {
            gen.writeNumberField("rating", value.getFeedbacks()
                    .stream()
                    .map(Feedback::getRating)
                    .reduce((Long::sum)).get() / value.getFeedbacks().size());
        } else {
            gen.writeNumberField("rating", 0);
        }
        gen.writeNumberField("page_count", value.getPageCount());
        gen.writeStringField("subtitle", value.getSubtitle());
        gen.writeStringField("description", value.getDescription());
        gen.writeArrayFieldStart("feedbacks");
        for(Feedback feedback : value.getFeedbacks()){
            gen.writeStartObject();
            gen.writeStringField("username", feedback.getUser().getUsername());
            gen.writeStringField("review", feedback.getReview());
            gen.writeNumberField("rating", feedback.getRating());
            gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeArrayFieldStart("history");
        for(History history : value.getHistory()){
            gen.writeStartObject();
            gen.writeStringField("username", history.getUser().getUsername());
            gen.writeStringField("date_issue", String.valueOf(history.getDateIssue()));
            gen.writeStringField("date_return", String.valueOf(history.getDateReturn()));
            gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
