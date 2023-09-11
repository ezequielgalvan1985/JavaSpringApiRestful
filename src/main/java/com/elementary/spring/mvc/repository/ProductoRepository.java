package com.elementary.spring.mvc.repository;

import java.util.List;

import com.elementary.spring.mvc.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "SELECT * FROM productos WHERE empresa_id = ?1 order by id desc", nativeQuery = true)
    List<Producto> findByEmpresaId(int empresaId);
}

