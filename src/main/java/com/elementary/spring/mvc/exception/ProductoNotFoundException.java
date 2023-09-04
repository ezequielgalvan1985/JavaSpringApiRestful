package com.elementary.spring.mvc.exception;

public class ProductoNotFoundException extends RuntimeException {

	public ProductoNotFoundException(Integer id) {
		super("No se Encontro ProductoId: " + id);
	}
}