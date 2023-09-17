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
import com.elementary.spring.mvc.core.enums.EstadoConstantes;
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query(value = "SELECT * FROM pedidos WHERE usuario_id = ?1 and estado ='"+EstadoConstantes.PENDIENTE+"' order by id desc limit 1", nativeQuery = true)
    Pedido getUltimoPendienteByUserId(int userId);
    @Query(value = "SELECT * FROM pedidos WHERE usuario_id = ?1 order by id desc", nativeQuery = true)
    List<Pedido> getAllByUser(int userId);

    @Query(value = "SELECT * FROM pedidos WHERE usuario_id = ?1 and empresa_id =?2 and estado ='"+EstadoConstantes.PENDIENTE+"' order by id desc", nativeQuery = true)
    List<Pedido> findByUserAndEmpresa(int userId, int empresaId);

    @Query(value = "SELECT * FROM pedidos WHERE usuario_id = ?1 and estado = '"+EstadoConstantes.PENDIENTE+"' order by id desc", nativeQuery = true)
    List<Pedido> findPendientesByUserId(int usuarioId);

    @Query(value = "SELECT * FROM pedidos WHERE usuario_id = ?1 and estado =?2  order by id desc", nativeQuery = true)
    List<Pedido> findByUserIdAndEstado(int usuarioId,int estadoId);

}

