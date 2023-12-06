package com.integrador.pedido.modelo.dto;

import com.integrador.pedido.modelo.entity.PedidoEntity;
import com.integrador.pedido.modelo.entity.PedidoProdutoEntity;
import com.integrador.produto.modelo.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PedidoProdutoDto {

    private Long id;

    private PedidoDto codigoPedido;

    private List<ProdutoDto> codigoProduto;

    private Long quantidadeProduto;
}
