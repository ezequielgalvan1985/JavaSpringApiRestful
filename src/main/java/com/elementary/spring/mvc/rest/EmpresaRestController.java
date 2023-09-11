package com.elementary.spring.mvc.rest;

import com.elementary.spring.mvc.exception.GenericNotFoundException;
import com.elementary.spring.mvc.exception.datospersonales.DatosPersonalesNotFoundException;
import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Empresa;
import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import com.elementary.spring.mvc.repository.CategoriaRepository;
import com.elementary.spring.mvc.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresas")
public class EmpresaRestController {
    private static final Logger log = LoggerFactory.getLogger(CategoriaRestController.class);
    @Autowired
    private EmpresaRepository repo;

    @GetMapping()
    public List<Empresa> findAll(){
        return repo.findAll();
    }

    @GetMapping(value="/{id}")
    public Empresa view(@PathVariable("id") Integer id){
        return repo.findById(id).orElseThrow(() -> new GenericNotFoundException("No se encontro EmpresaID:"+ id.toString()));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Empresa e){
        repo.save(e);
    }

    @PutMapping()
    public void edit(@RequestBody Empresa e){
        repo.save(e);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") Integer id){
        repo.deleteById(id);
    }

    @GetMapping(value="/consultas/findbyuser/{id}")
    public Empresa findByUserId(@PathVariable("id") Integer id){

        Empresa d = repo.findByUserId(id);
        if (d==null) throw new GenericNotFoundException("No se encontraron Datos de Empresa para el usuario "+ id);
        return d;
    }

    @GetMapping(value="/consultas/findbyrubro/{id}")
    public List<Empresa> findByRubroId(@PathVariable("id") Integer id){

        List<Empresa> result = repo.findByRubroId(id);
        if (result==null) throw new GenericNotFoundException("No se encontraron Empresas para el Rubro "+ id);
        return result;
    }

}
