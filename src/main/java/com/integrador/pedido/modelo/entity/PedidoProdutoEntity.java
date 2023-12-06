package com.integrador.pedido.modelo.entity;

import com.integrador.pedido.modelo.dto.PedidoDto;
import com.integrador.pedido.modelo.dto.PedidoProdutoDto;
import com.integrador.produto.modelo.dto.ProdutoDto;
import com.integrador.produto.modelo.entity.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "pedido_produto")
@Table(name="pedido_produto",schema = "integrador")
public class PedidoProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "codped_ppd", referencedColumnName = "id")
    private PedidoEntity codped_ppd;

    @OneToOne
    @JoinColumn(name = "codprd_ppd", referencedColumnName = "id")
    private ProdutoEntity codprd_ppd;

    @Column(name="quanti_ppd")
    private Long quanti_ppd;

}
