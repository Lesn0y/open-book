package com.lesnoy.openbook.history;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class HistorySerializer extends StdSerializer<History> {
    public HistorySerializer() {
        this(null);
    }

    public HistorySerializer(Class<History> t) {
        super(t);
    }

    @Override
    public void serialize(History value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectFieldStart("user");
            gen.writeNumberField("id", value.getUser().getId());
            gen.writeStringField("username", value.getUser().getUsername());
            gen.writeStringField("email", value.getUser().getEmail());
        gen.writeEndObject();
        gen.writeObjectFieldStart("book");
            gen.writeNumberField("id", value.getBook().getId());
            gen.writeStringField("thumbnailUrl", value.getBook().getThumbnailUrl());
            gen.writeStringField("name", value.getBook().getName());
            gen.writeStringField("author", value.getBook().getAuthor().getFullName());
        gen.writeEndObject();
        gen.writeStringField("date_issue", String.valueOf(value.getDateIssue()));
        gen.writeStringField("date_return", String.valueOf(value.getDateReturn()));
        gen.writeEndObject();
    }
}
