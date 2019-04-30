package com.digitaledu.handler;

import com.digitaledu.dto.ResponseDTO;
import com.digitaledu.exception.DuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleValidation() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ResponseDTO.builder()
                        .success(false)
                        .content("Something Wrong")
                        .build()
        );
    }

    @ExceptionHandler(value = DuplicateException.class)
    public ResponseEntity duplicateEntry(DuplicateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ResponseDTO.builder()
                        .success(false)
                        .content(ex.getMessage())
                        .build()
        );
    }

}
