package com.elementary.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.elementary.spring.mvc.model.Categoria;
import com.elementary.spring.mvc.model.Employee;
import com.elementary.spring.mvc.model.Estado;
import com.elementary.spring.mvc.model.Marca;
import com.elementary.spring.mvc.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query(value = "SELECT * FROM pedidos WHERE usuario_id = ?1 order by id desc limit 1", nativeQuery = true)
    Pedido getByUserId(int userId);
}

