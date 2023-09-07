package com.elementary.spring.mvc.repository;

import com.elementary.spring.mvc.model.Pedido;
import com.elementary.spring.mvc.model.UsuarioDatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioDatosPersonalesRepository extends JpaRepository<UsuarioDatosPersonales, Integer> {
    @Query(value = "SELECT d.* FROM users u inner join usuario_datos_personales d on u.datos_personales_id = d.id WHERE u.id = ?1 limit 1", nativeQuery = true)
    UsuarioDatosPersonales findByUserId(int userId);
}
