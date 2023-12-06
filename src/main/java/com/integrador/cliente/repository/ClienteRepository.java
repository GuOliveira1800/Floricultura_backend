package com.integrador.cliente.repository;

import com.integrador.pedido.modelo.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.integrador.cliente.modelo.entity.ClienteEntity;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long>, JpaSpecificationExecutor<ClienteEntity>{
    @Query("SELECT cc FROM cliente cc WHERE cc.nome_cli LIKE %:nome%")
    List<ClienteEntity> findBynomeCliente(@Param("nome") String nome);

}
