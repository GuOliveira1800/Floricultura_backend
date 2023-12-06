package com.integrador.entrada.modelo.dto;

import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.entrada.modelo.entity.EntradaEntity;
import com.integrador.fornecedor.modelo.dto.FornecedorDto;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;
import com.integrador.produto.modelo.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDto {

	private Long codigo_ent;
	private ProdutoDto codprd_ent;
	private FornecedorDto codfor_ent;
	private int quanti_ent;
	private float valuni_ent;
	private Date datent_ent;
	
	public EntradaEntity dtoToEntity() {
		EntradaEntity entradaEntity = new EntradaEntity();

		entradaEntity.setCodigo_ent(this.codigo_ent);
		entradaEntity.setDatent_ent(this.datent_ent);
		entradaEntity.setQuanti_ent(this.quanti_ent);
		entradaEntity.setValuni_ent(this.valuni_ent);
		entradaEntity.setCodfor_ent(this.codfor_ent.dtoToEntity());
		entradaEntity.setCodprd_ent(this.codprd_ent.toEntity());
		
		return entradaEntity;
	}

}
