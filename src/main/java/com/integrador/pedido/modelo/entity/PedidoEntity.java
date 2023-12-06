package com.integrador.pedido.modelo.entity;

import com.integrador.cliente.modelo.entity.ClienteEntity;
import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.pedido.modelo.dto.PedidoDto;
import com.integrador.pedido.modelo.dto.PedidoProdutoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "pedido")
@Table(name="pedido",schema = "integrador")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "codcli_ped", referencedColumnName = "id")
    private ClienteEntity codcli_ped;

    @Column(name="status_ped")
    private long status_ped;

    @Column(name="valtot_ped")
    private double valtot_ped;

    @Column(name="datcri_ped")
    private Date datcri_ped;

    @Column(name="datreg_ped")
    private Date datreg_ped;

    @Column(name="datfim_ped")
    private Date datfim_ped;

    public PedidoDto entToDto(){
        return new PedidoDto(this.id,this.codcli_ped.entToDto(),this.status_ped,this.valtot_ped,this.datcri_ped,this.datreg_ped,this.datfim_ped);
    }

}
