package com.example.session09.exception;

import com.example.session09.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String,String> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().
                forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
        ApiResponse<Map<String,String>> response = new ApiResponse<>();
        response.setStatus("FAIL");
        response.setMessage("Dữ liệu không hợp lệ");
        response.setData(map);
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String,String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        ApiResponse<Map<String,String>> response = new ApiResponse<>();
        response.setStatus("FAIL");
        response.setMessage("Lỗi hệ thống upload");
        response.setData(map);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String,String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        ApiResponse<Map<String,String>> response = new ApiResponse<>();
        response.setStatus("FAIL");
        response.setMessage("Dữ liệu không hợp lệ");
        response.setData(map);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleDuplicateResourceException(DuplicateResourceException ex) {
        Map<String,String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        ApiResponse<Map<String,String>> response = new ApiResponse<>();
        response.setStatus("FAIL");
        response.setMessage("Dữ liệu không hợp lệ");
        response.setData(map);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
