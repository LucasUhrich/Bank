package com.project.bank.Controller;

import com.project.bank.Response.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseApi> handleInvalidArguments(MethodArgumentNotValidException ex) {
        ResponseApi responseApi = new ResponseApi();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        responseApi.setStatus(HttpStatus.BAD_REQUEST.toString());
        responseApi.setMessage("Invalid fields data");
        responseApi.setData(errors);
        return ResponseEntity.badRequest().body(responseApi);
    }
}
