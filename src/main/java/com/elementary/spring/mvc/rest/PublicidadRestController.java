package com.elementary.spring.mvc.rest;

import com.elementary.spring.mvc.exception.GenericNotFoundException;
import com.elementary.spring.mvc.exception.datospersonales.DatosPersonalesNotFoundException;
import com.elementary.spring.mvc.model.Publicidad;
import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import com.elementary.spring.mvc.repository.PublicidadRepository;
import com.elementary.spring.mvc.repository.UsuarioDatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publicidades")
public class PublicidadRestController {
	@Autowired
	private PublicidadRepository repo;

	
	@GetMapping()
	public List<Publicidad> findAll(){
		return repo.findAll();
	}  
	
	@GetMapping(value="/{id}")
	public Publicidad view(@PathVariable("id") Integer id){
		return repo.findById(id).orElseThrow(() -> new GenericNotFoundException("No se encontro Publicidad con el id > "+ id));
	}  
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Publicidad e){
		repo.save(e);
	}

	@PatchMapping()
	public void edit(@RequestBody Publicidad e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}

	@GetMapping(value="/consultas/findbyempresa/{id}")
	public List<Publicidad> findByEmpresaId(@PathVariable("id") Integer id){
			List<Publicidad> result = repo.findByEmpresaId(id);
			if (result==null) throw new GenericNotFoundException("No se encontro Publicidad para la Empresa > "+ id);
			return result;
	}

}
