package com.elementary.spring.mvc.exception.datospersonales;

import com.elementary.spring.mvc.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DatosPersonalesNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(DatosPersonalesNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ExceptionResponse datosPersonalesNotFoundHandler(DatosPersonalesNotFoundException ex) {
    return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),"");
  }
}