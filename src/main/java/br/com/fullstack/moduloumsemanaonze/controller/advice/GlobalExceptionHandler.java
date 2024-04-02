package br.com.fullstack.moduloumsemanaonze.controller.advice;

import br.com.fullstack.moduloumsemanaonze.response.errorValidation.ValidationErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationErrorDetails> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(new ValidationErrorDetails(fieldName, errorMessage));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handleHttpMessageNotReadableException(NoSuchElementException ex) {
        List<ValidationErrorDetails> errors = new ArrayList<>();

        String campo = "ID não encontrado";
        String errorMessage = ex.getMessage();
        errors.add(new ValidationErrorDetails(campo, errorMessage));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }


}
