package com.elementary.spring.mvc.rest;

import java.util.List;

import com.elementary.spring.mvc.exception.GenericNotFoundException;
import com.elementary.spring.mvc.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
		Producto result = repo.findById(id).get();
		if (result==null) throw new GenericNotFoundException("No se encontro Producto para ID "+ id);
		return result;
	}  
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Producto e){
		log.info("create producto: " + e.toString());
		repo.save(e);
	}

	@PatchMapping()
	public void edit(@RequestBody Producto e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}

	@GetMapping(value="/consultas/findbyempresa/{empresaId}")
	public List<Producto>  findByEmpresaId(@PathVariable("empresaId") Integer empresaId) {
		return repo.findByEmpresaId(empresaId);
	}
}
