package com.restaurant.survey.adapter.controller;


import com.restaurant.survey.adapter.controller.model.ErrorResponse;
import com.restaurant.survey.adapter.controller.model.ResponseRestStatus;
import com.restaurant.survey.adapter.repository.exception.NotFoundRepositoryException;
import com.restaurant.survey.config.ErrorMessage;
import com.restaurant.survey.config.exception.GenericException;
import java.util.List;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handle(Throwable ex) {
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessage.INTERNAL_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handle(HttpMessageNotReadableException ex) {
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.BAD_REQUEST, ErrorMessage.BAD_REQUEST_EXCEPTION);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException ex) {
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.BAD_REQUEST, ErrorMessage.BAD_REQUEST_EXCEPTION);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentTypeMismatchException ex) {
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.BAD_REQUEST, ErrorMessage.BAD_REQUEST_EXCEPTION);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException ex) {
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.BAD_REQUEST, ErrorMessage.BAD_REQUEST_EXCEPTION);
    }

    @ExceptionHandler(NotFoundRepositoryException.class)
    public ResponseEntity<ErrorResponse> handle(GenericException ex) {
        log.error(HttpStatus.NOT_FOUND.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.NOT_FOUND, ex.getCode());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handle(DataIntegrityViolationException ex) {
        log.error(HttpStatus.NOT_FOUND.getReasonPhrase(), ex);
        return buildResponseError(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> buildResponseError(HttpStatus httpStatus, ErrorMessage errorMsg) {

        final var apiErrorResponse = ErrorResponse
                .builder()
                .status(ResponseRestStatus.ERROR)
                .errors(List.of(errorMsg.getReasonPhrase()))
                .build();

        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }
}

