package com.elementary.spring.mvc.repository;

import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Empresa;
import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
    @Query(value = "SELECT * FROM empresas WHERE usuario_id = ?1 limit 1", nativeQuery = true)
    Empresa findByUserId(int userId);
}
