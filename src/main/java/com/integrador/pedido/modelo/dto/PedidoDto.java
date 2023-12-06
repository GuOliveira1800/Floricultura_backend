package com.integrador.pedido.modelo.dto;

import com.integrador.cliente.modelo.dto.ClienteDto;
import com.integrador.pedido.modelo.entity.PedidoEntity;
import com.integrador.pedido.modelo.entity.PedidoProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PedidoDto {

    private Long id;
    private ClienteDto codigoCliente;
    private Long status;
    private double valorTotal;
    private Date dataCriacao;
    private Date dataRegistro;
    private Date dataFinal;
    public PedidoEntity toEntity() {
        PedidoEntity pedidoEntity = new PedidoEntity();

        pedidoEntity.setId(this.id);
        pedidoEntity.setCodcli_ped(this.codigoCliente.toEntity());
        pedidoEntity.setValtot_ped(this.valorTotal);
        pedidoEntity.setStatus_ped(this.status);
        pedidoEntity.setDatcri_ped(this.dataCriacao);
        pedidoEntity.setDatreg_ped(this.dataRegistro);
        pedidoEntity.setDatcri_ped(this.dataCriacao);

        return pedidoEntity;
    }

}
