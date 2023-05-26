package org.bedu.java.backend.retoSesion4.config;

import org.bedu.java.backend.retoSesion4.exception.MonedaAlreadyExistsException;
import org.bedu.java.backend.retoSesion4.exception.MonedaNotFoundException;
import org.bedu.java.backend.retoSesion4.model.response.ErrorRespons;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MonedaNotFoundException.class)
    public ResponseEntity<ErrorRespons> handleNotFound(MonedaNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorRespons(ex.getName() + " No se encontro en el catálogo de monedas"));
    }

    @ExceptionHandler(MonedaAlreadyExistsException.class)
    public ResponseEntity<ErrorRespons> handleAlreadyExists() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorRespons("Moneda ya existe"));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorRespons> handleNullPointer() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorRespons("Sucedio un error"));
    }
}
