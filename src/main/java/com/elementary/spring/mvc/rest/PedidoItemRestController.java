package com.elementary.spring.mvc.rest;

import java.util.List;

import com.elementary.spring.mvc.dto.PedidoItemUpdCantidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elementary.spring.mvc.repository.PedidoItemRepository;
import com.elementary.spring.mvc.model.Marca;
import com.elementary.spring.mvc.model.PedidoItem;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1/pedidoitems")
public class PedidoItemRestController {
	
	@Autowired
	private PedidoItemRepository repo;
	
	@GetMapping()
	public List<PedidoItem> findAll(){
		return repo.findAll();
	}  
	
	@GetMapping(value="/{id}")
	public PedidoItem view(@PathVariable("id") Integer id){
		return repo.findById(id).get();
	}  
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody PedidoItem e){
		repo.save(e);
	}

	@PatchMapping()
	public void edit(@RequestBody PedidoItem e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}
	@PostMapping(value="/accion/upd/cantidad")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updCantidad(@RequestBody PedidoItemUpdCantidadDto e){
		PedidoItem item = repo.findById(e.getId()).get();
		item.setCantidad(e.getCantidad());
		repo.save(item);
	}
}
