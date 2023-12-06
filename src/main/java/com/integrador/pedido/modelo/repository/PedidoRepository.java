package com.integrador.pedido.modelo.repository;

import com.integrador.pedido.modelo.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity,Long>, JpaSpecificationExecutor<PedidoEntity> {
}
