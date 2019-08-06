package com.stackroute.trackservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* Spring support for a global @ExceptionHandler with the @ControllerAdvice annotation. This enables a mechanism that
breaks away from the older MVC model and makes use of ResponseEntity along with the type safety and flexibility
 of @ExceptionHandler:*/
@ControllerAdvice
public class GlobalException
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {TrackAlreadyExistsException.class, TrackNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request) {
        String bodyOfResponse = null;
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }
}