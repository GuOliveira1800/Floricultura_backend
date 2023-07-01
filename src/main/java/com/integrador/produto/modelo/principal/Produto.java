package com.integrador.produto.modelo.principal;

import lombok.Data;

@Data
public class Produto {

	private Long codigo_prd;
	private String nome_prd;
	private String descri_prd;
	private Long qtd_prd;
	private Double valuni_prd;
	private byte[] foto_prd;
	
}
