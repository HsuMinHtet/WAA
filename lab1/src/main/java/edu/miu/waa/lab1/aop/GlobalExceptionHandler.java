package edu.miu.waa.lab1.aop;

import edu.miu.waa.lab1.dto.ErrorType;
import edu.miu.waa.lab1.exception.PostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PostException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleBadRequestException(PostException exception) {
        return new ResponseEntity<>(new ErrorType(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
