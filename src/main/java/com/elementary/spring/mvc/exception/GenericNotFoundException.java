package com.elementary.spring.mvc.exception;

public class GenericNotFoundException extends RuntimeException{
    public GenericNotFoundException(String mensaje) {
        super(mensaje);
    }
}
