package com.elementary.spring.mvc.repository;


import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Publicidad;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublicidadRepository extends JpaRepository<Publicidad, Integer> {

}

