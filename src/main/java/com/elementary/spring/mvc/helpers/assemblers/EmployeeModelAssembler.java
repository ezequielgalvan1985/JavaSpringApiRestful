package com.elementary.spring.mvc.helpers.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.elementary.spring.mvc.model.Employee;
import com.elementary.spring.mvc.rest.EmployeeRestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
    
  @Override
  public EntityModel<Employee> toModel(Employee entity) {

    return new EntityModel<Employee>(entity,
			    linkTo(methodOn(EmployeeRestController.class).view(entity.getId())).withSelfRel(),
			    linkTo(methodOn(EmployeeRestController.class).all()).withRel("employees")); 
  }
}
