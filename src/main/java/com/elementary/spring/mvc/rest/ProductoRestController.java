package com.elementary.spring.mvc.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.elementary.spring.mvc.repository.ProductoRepository;
import com.elementary.spring.mvc.exception.productos.ProductoNotFoundException;
import com.elementary.spring.mvc.model.Producto;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1/productos")
public class ProductoRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoRestController.class);


	@Autowired
	private ProductoRepository repo;
	
	@GetMapping()
	public List<Producto> findAll(){
		return repo.findAll();
	}  
	
	@GetMapping(value="/{id}")
	public Producto view(@PathVariable("id") Integer id){
		return repo.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
	}  
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Producto e){
		log.info("create producto: " + e.toString());
		repo.save(e);
	}

	@PutMapping()
	public void edit(@RequestBody Producto e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}
	
}
