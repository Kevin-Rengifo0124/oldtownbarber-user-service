package com.oldtownbarber.user_service.exception;

import com.oldtownbarber.user_service.payload.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(Exception exception, WebRequest webRequest) {

        ExceptionResponse response = new ExceptionResponse(
                exception.getMessage(),
                webRequest.getDescription(false), LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }

}
