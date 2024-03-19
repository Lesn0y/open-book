package org.lesnoy.bookservice.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApiError {

    @JsonProperty("error-code")
    private int errorCode;
    private String description;
    private Date date;

}