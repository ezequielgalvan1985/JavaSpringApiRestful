package com.elementary.spring.mvc.helpers.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.rest.CategoriaRestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CategoriaModelAssembler implements RepresentationModelAssembler<Categoria, EntityModel<Categoria>> {
    @Override
  public EntityModel<Categoria> toModel(Categoria entity) {

    return new EntityModel<Categoria>(entity,
			    linkTo(methodOn(CategoriaRestController.class).view(entity.getId())).withSelfRel(),
			    linkTo(methodOn(CategoriaRestController.class).all()).withRel("categorias")); 
  }
}
