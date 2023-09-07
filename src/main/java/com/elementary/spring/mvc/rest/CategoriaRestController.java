package com.elementary.spring.mvc.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.elementary.spring.mvc.repository.CategoriaRepository;


import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.exception.categorias.CategoriaNotFoundException;
import com.elementary.spring.mvc.helpers.assemblers.CategoriaModelAssembler;

import org.springframework.http.HttpStatus;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1/categorias")

public class CategoriaRestController {
	
	private static final Logger log = LoggerFactory.getLogger(CategoriaRestController.class);


	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
  	private  CategoriaModelAssembler assembler;

	public List<Categoria> findAll(){
			List<Categoria> t =repo.findAll();
			return t;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping()
	public List<Categoria> all() {
		/*
		List<EntityModel<Categoria>> categorias =
				repo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return new CollectionModel (categorias, linkTo(methodOn(CategoriaRestController.class).all()).withSelfRel());
		*/
		return repo.findAll();

	}


	@GetMapping(value="/{id}")
	public EntityModel<Categoria> view(@PathVariable("id") Integer id){
		Categoria c =repo.findById(id).orElseThrow(() -> new CategoriaNotFoundException(id));
		return assembler.toModel(c);

	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Categoria e){
		log.info("create categoria: " + e.toString());
		repo.save(e);
	}


	@PutMapping()
	@CrossOrigin(origins ="http://localhost:3000")
	public void edit(@RequestBody Categoria e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@CrossOrigin(origins ="http://localhost:3000")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}



}
