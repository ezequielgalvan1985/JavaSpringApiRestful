package com.elementary.spring.mvc.exception.datospersonales;

public class DatosPersonalesNotFoundException extends RuntimeException {

	public DatosPersonalesNotFoundException(Integer id) {
		super("No se encontraron datos personales");
	}
}