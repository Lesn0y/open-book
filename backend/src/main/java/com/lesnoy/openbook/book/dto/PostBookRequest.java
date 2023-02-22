package com.lesnoy.openbook.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBookRequest {
    @JsonProperty("book_name")
    private String bookName;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    private String author;
    @JsonProperty("page_count")
    private int pageCount;
    private String subtitle;
    private List<String> genres;
    private String description;
    private List<String> gallery;
}
