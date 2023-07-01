package com.integrador.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	private Long codigo_cli;
	private String nome_cli;
	private String docume_cli;
	private String cep_end;	
	private String telefo_cli;
	private String cidade_end;
	private String uf_end;
	private String rua_end;
	private byte[] foto_cli;
	
	public ClienteDto(Long codigo_cli, String nome_cli, String docume_cli, String cep_end, String telefo_cli, byte[] foto_cli) {
		super();
		this.codigo_cli = codigo_cli;
		this.nome_cli = nome_cli;
		this.docume_cli = docume_cli;
		this.cep_end = cep_end;
		this.telefo_cli = telefo_cli;
		this.foto_cli = foto_cli;
	}
	
	public ClienteDto(String nome_cli, String docume_cli, String cep_end, String telefo_cli) {
		this.nome_cli = nome_cli;
		this.docume_cli = docume_cli;
		this.cep_end = cep_end;
		this.telefo_cli = telefo_cli;
	}
}
