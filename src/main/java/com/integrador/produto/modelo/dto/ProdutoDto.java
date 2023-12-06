package com.integrador.produto.modelo.dto;

import com.integrador.produto.modelo.entity.ProdutoEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
	
	private Long id;
	private String nome_prd;
	private String descri_prd;
	private Long qtd_prd;
	private Double valuni_prd;
	private byte[] foto_prd;

	public ProdutoEntity toEntity() {
		ProdutoEntity produtoEntity = new ProdutoEntity();
		
		produtoEntity.setId(id);
		produtoEntity.setDescri_prd(descri_prd);
		produtoEntity.setNome_prd(nome_prd);
		produtoEntity.setQtd_prd(qtd_prd);
		produtoEntity.setValuni_prd(valuni_prd);
		produtoEntity.setFoto_prd(foto_prd);
		
		return produtoEntity;
	}
	
}
