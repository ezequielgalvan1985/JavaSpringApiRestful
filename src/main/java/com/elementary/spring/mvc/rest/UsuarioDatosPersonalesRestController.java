package com.elementary.spring.mvc.rest;

import com.elementary.spring.mvc.exception.GenericNotFoundException;
import com.elementary.spring.mvc.exception.datospersonales.DatosPersonalesNotFoundException;
import com.elementary.spring.mvc.exception.productos.ProductoNotFoundException;
import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import com.elementary.spring.mvc.repository.UsuarioDatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/datospersonales")
public class UsuarioDatosPersonalesRestController {
	@Autowired
	private UsuarioDatosPersonalesRepository repo;

	
	@GetMapping()
	public List<UsuarioDatosPersonales> findAll(){
		return repo.findAll();
	}  
	
	@GetMapping(value="/{id}")
	public UsuarioDatosPersonales view(@PathVariable("id") Integer id){
		return repo.findById(id).orElseThrow(() -> new DatosPersonalesNotFoundException(id));
	}  
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody UsuarioDatosPersonales e){
		repo.save(e);
	}

	@PutMapping()
	public void edit(@RequestBody UsuarioDatosPersonales e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}

	@GetMapping(value="/consultas/findbyuser/{id}")
	public UsuarioDatosPersonales findByUserId(@PathVariable("id") Integer id){

		UsuarioDatosPersonales d = repo.findByUserId(id);
		if (d==null) throw new GenericNotFoundException("No se encontraron datos personales para el usuario "+ id);
		return d;
	}

}
