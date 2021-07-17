package com.example.employee.error_handler;

import com.example.employee.exception.EmployeeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
            Map<String, Object> validationErrors = new HashMap<>();
            Map<String ,String> fieldToErrorMap = new HashMap<>();

            validationErrors.put("errors", fieldToErrorMap);


            ex.getBindingResult().getAllErrors().forEach(
                    error -> {
                        fieldToErrorMap.put(((FieldError) error).getField(), error.getDefaultMessage());
                    }
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);

    }

    @ExceptionHandler(EmployeeException.class)
    protected ResponseEntity<Object> handleEmployeeException(EmployeeException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Pong");
    }


}


