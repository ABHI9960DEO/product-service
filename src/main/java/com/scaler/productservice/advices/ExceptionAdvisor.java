package com.scaler.productservice.advices;

import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvisor {
//    @ExceptionHandler(RuntimeException.class)
//    public ErrorResponseException handleException(Exception ex){
//        return new ErrorResponseException();
//    }
}
