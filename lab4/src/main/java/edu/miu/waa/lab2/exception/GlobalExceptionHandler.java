package edu.miu.waa.lab2.exception;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BadCredentialsException.class) // when Invalid Credentials
    public ResponseEntity<ErrorMessage> handleInvalidCredentialsException(
            BadCredentialsException e) {
        return new ResponseEntity<ErrorMessage>(
                new ErrorMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
