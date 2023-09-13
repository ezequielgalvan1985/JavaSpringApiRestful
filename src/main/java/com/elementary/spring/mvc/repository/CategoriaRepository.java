package com.elementary.spring.mvc.repository;


import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elementary.spring.mvc.model.Categoria;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query(value = "SELECT c.* FROM categorias c inner join rubros r on c.rubro_id = r.id WHERE rubro_id = ?1", nativeQuery = true)
    List<Categoria> findByRubroId(int rubroId);
}

