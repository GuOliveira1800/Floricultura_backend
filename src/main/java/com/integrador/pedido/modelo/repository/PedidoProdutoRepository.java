package com.integrador.pedido.modelo.repository;

import com.integrador.pedido.modelo.entity.PedidoEntity;
import com.integrador.pedido.modelo.entity.PedidoProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProdutoEntity,Long>, JpaSpecificationExecutor<PedidoProdutoEntity> {

    @Query("SELECT pp FROM pedido_produto pp WHERE pp.codped_ppd.id = :codigo")
    List<PedidoProdutoEntity> findBycodigo(@Param("codigo") Long codigo);

    @Query("SELECT pp FROM pedido_produto pp WHERE pp.codped_ppd.id = :codigoPedido and pp.codprd_ppd.id = :codigoProduto")
    Optional<PedidoProdutoEntity> findByPedPro(@Param("codigoPedido") Long codigoPedido, @Param("codigoProduto") Long codigoProduto);


}
