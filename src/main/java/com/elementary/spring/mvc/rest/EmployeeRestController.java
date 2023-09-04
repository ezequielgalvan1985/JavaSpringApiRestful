package com.elementary.spring.mvc.rest;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.spring.mvc.exception.EmployeeNotFoundException;
import com.elementary.spring.mvc.helpers.assemblers.EmployeeModelAssembler;
import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Employee;
import com.elementary.spring.mvc.repository.EmployeeRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/v1/employees")
public class EmployeeRestController {

  private  EmployeeRepository repository;
  
  @Autowired
  private  EmployeeModelAssembler assembler;


  public EmployeeRestController(EmployeeRepository repository) {
    this.repository = repository;
  }

@GetMapping()
@CrossOrigin(origins="http://localhost:3000")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public CollectionModel<EntityModel<Employee>> all() {

    List<EntityModel<Employee>> employees =
            repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
    return new CollectionModel (employees, linkTo(methodOn(EmployeeRestController.class).all()).withSelfRel());
    
}

  @PostMapping("/")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }
    

    @GetMapping(value="/{id}")
	public EntityModel<Employee> view(@PathVariable("id") Long id){
		
        Employee entity =repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		
        return assembler.toModel(entity);

	}

  @PutMapping("/replace/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}