package org.lesnoy.inventoryservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(Exception e) {
        ApiError error = new ApiError(404, e.getMessage(), new Date());
        log.info("Returned status 404, api error - '" + error + "'");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}