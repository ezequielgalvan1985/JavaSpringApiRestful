package com.elementary.spring.mvc.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.spring.mvc.repository.CategoriaRepository;
import com.elementary.spring.mvc.repository.MarcaRepository;
import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Marca;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaRepository repo;
	
	@GetMapping()
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Categoria view(@PathVariable("id") Integer id){
		Categoria c=null;
		try{
			c = repo.findById(id).get();
		}catch(Exception e) {
			if (c==null) {
				throw new EntityNotFoundException(String.format("No se encontro categora %s", id.toString()));	
			}
		}
		return c;
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Categoria e){
		repo.save(e);
	}

	@PutMapping()
	public void edit(@RequestBody Categoria e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}
	
}
