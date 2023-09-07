package com.elementary.spring.mvc.exception;

import com.elementary.spring.mvc.exception.categorias.CategoriaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GenericNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GenericNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionResponse genericNotFoundHandler(GenericNotFoundException ex) {

        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),"");
    }
}
