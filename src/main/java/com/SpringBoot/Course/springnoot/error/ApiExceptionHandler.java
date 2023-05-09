package com.SpringBoot.Course.springnoot.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler {

     @ExceptionHandler(ApiBaseHandler.class)
     public ResponseEntity<ErrorDetails> handleApiEx(ApiBaseHandler ex, WebRequest request){
         ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(details,ex.getStatuesCode());
     }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
         Validation validationError = new Validation();
         validationError.setUri(request.getDescription(false));
         List<FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors();

         for(FieldError f: fieldErrorList){
             validationError.addError(f.getDefaultMessage());
         }

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
