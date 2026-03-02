package com.example.demo.Error;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //404 처리
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus
    public ErrorResponse
    handleResponseStatusException(ResponseStatusException e) {
        HttpStatus status = HttpStatus.valueOf(e.getStatusCode().value());
        return new ErrorResponse(
                status.value(),
                status.name(),
                e.getReason() != null ? e.getReason() : "요청 처리 중 오류가 발생했습니다.");
    }
    //Validation 실패 처리

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse
    handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();

        return new ErrorResponse(400, "VALIDATION_ERROR", message);
    }
}
