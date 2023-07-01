package com.integrador.usuario.modelo.principal;

import lombok.Data;

@Data
public class Usuario {

	private Long codigo_usu;	
	private String login_usu;	
	private String senha_usu;
	private String nome_usu;
	
}
