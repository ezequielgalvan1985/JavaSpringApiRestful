package com.elementary.spring.mvc.rest;

import com.elementary.spring.mvc.exception.GenericNotFoundException;
import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Rubro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.elementary.spring.mvc.repository.RubroRepository;
import java.util.List;

import com.elementary.spring.mvc.exception.GenericNotFoundException;
@RestController
@RequestMapping("/v1/rubros")

public class RubroRestController {
	
	private static final Logger log = LoggerFactory.getLogger(RubroRestController.class);

	@Autowired
	private RubroRepository repo;

	@GetMapping()
	public List<Rubro> findAll(){
			List<Rubro> t =repo.findAll();
			return t;
	}

	@GetMapping(value="/{id}")
	public Rubro view(@PathVariable("id") Integer id){
		return repo.findById(id).orElseThrow(() -> new GenericNotFoundException("No se encontraron datos personales para el usuario "+ id));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Rubro e){
		log.info("create rubro: " + e.toString());
		repo.save(e);
	}


	@PutMapping()
	@CrossOrigin(origins ="http://localhost:3000")
	public void edit(@RequestBody Rubro e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}



}
