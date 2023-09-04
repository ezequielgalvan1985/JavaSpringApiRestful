package com.elementary.spring.mvc.exception;

public class CategoriaNotFoundException extends RuntimeException {

	public CategoriaNotFoundException(Integer id) {
		super("No se Encontro CategoriaId: " + id);
	}
}