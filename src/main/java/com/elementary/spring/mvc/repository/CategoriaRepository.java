package com.elementary.spring.mvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.elementary.spring.mvc.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}

