package com.elementary.spring.mvc.rest;

import java.util.List;

import com.elementary.spring.mvc.core.enums.Estado;
import com.elementary.spring.mvc.dto.PedidoItemDto;
import com.elementary.spring.mvc.dto.PedidoUpdEstadoDto;
import com.elementary.spring.mvc.exception.EmployeeNotFoundException;
import com.elementary.spring.mvc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elementary.spring.mvc.repository.PedidoRepository;
import com.elementary.spring.mvc.model.Marca;
import com.elementary.spring.mvc.model.Pedido;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoRestController {
	
	@Autowired
	private PedidoRepository repo;
	
	@GetMapping()
	public List<Pedido> findAll(){
		return repo.findAll();
	}  
	@GetMapping(value="/{id}")
	public Pedido view(@PathVariable("id") Integer id){
		return repo.findById(id).get();
	}  
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public int add(@RequestBody Pedido e){

		return repo.save(e).getId();
	}

	@PutMapping()
	public void edit(@RequestBody Pedido e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}

	@GetMapping(value="/consultas/getultimopendiente/{userId}")
	public Pedido getUltimoPendiente(@PathVariable("userId") Integer userId) {

		return repo.getUltimoPendienteByUserId(userId);
	}
	@GetMapping(value="/consultas/getbyuser/{userId}")
	public List<Pedido> getAllByUser(@PathVariable("userId") Integer userId) {
		return repo.getAllByUser(userId);
	}
	@PatchMapping(value="/accion/upd/estado")
	public void updEstado(@RequestBody PedidoUpdEstadoDto e) {
		Pedido p = repo.findById(e.getId()).get();
		p.setEstado(e.getEstado());
		repo.save(p);
	}
}
