package com.elementary.spring.mvc.rest;

import java.util.List;

import com.elementary.spring.mvc.dto.pedidos.PedidoFindByUserEmpresaRequestDto;
import com.elementary.spring.mvc.dto.pedidos.PedidoUpdEstadoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elementary.spring.mvc.repository.PedidoRepository;
import com.elementary.spring.mvc.model.Pedido;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoRestController {
	private static final Logger log = LoggerFactory.getLogger(CategoriaRestController.class);

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

	@PostMapping(value="/consultas/findultimopendientebyuserandempresa")
	public List<Pedido> findByUserAndEmpresa(@RequestBody PedidoFindByUserEmpresaRequestDto p) {
		log.info( p.toString());
		return repo.findByUserAndEmpresa(p.getUserId(), p.getEmpresaId());
	}
	@GetMapping(value="/consultas/findpendientesbyuser/{userId}")
	public List<Pedido> findPendientesByUserId(@PathVariable("userId") Integer id) {
		log.info( id.toString());
		return repo.findPendientesByUserId(id);
	}


}
