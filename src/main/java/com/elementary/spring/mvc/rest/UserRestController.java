package com.elementary.spring.mvc.rest;

import java.util.List;

import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import com.elementary.spring.mvc.repository.UsuarioDatosPersonalesRepository;
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

import com.elementary.spring.mvc.repository.UsuarioRepository;
import com.elementary.spring.mvc.model.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/v1/users")
public class UserRestController {
	
	
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private UsuarioDatosPersonalesRepository repoDatosPersonales;
	@Autowired
	private BCryptPasswordEncoder encoder; 
	
	@GetMapping()
	public List<Usuario> findAll(){
		return repo.findAll();
	}  
	
	@GetMapping(value="/{id}")
	public Usuario view(@PathVariable("id") Integer id){
		return repo.findById(id).get();
	}  
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Usuario e){
		e.setPassword(encoder.encode(e.getPassword()));
		repo.save(e);
		//crear datos personales y asociarlo
		UsuarioDatosPersonales datospersonales = new UsuarioDatosPersonales();

		datospersonales.setNombre(e.getUsername());
		datospersonales.setApellido("completar apellido");
		datospersonales.setDireccion("completar direccion");

		int idDatosPersonales = repoDatosPersonales.save(datospersonales).getId();
		datospersonales.setId(idDatosPersonales);

		e.setDatosPersonales(datospersonales);
		repo.save(e);

	}

	@PutMapping()
	public void edit(@RequestBody Usuario e){
		repo.save(e);
	}

	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}
	
}
