package com.elementary.spring.mvc.repository;


import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Publicidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PublicidadRepository extends JpaRepository<Publicidad, Integer> {
    @Query(value = "SELECT * FROM publicidades  WHERE empresa_id = ?1", nativeQuery = true)
    List<Publicidad> findByEmpresaId(int id);
}

