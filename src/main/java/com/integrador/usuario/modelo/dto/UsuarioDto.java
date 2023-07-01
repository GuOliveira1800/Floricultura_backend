package com.integrador.usuario.modelo.dto;

import com.integrador.usuario.modelo.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	private Long codigo_usu;	
	private String login_usu;	
	private String senha_usu;
	private String nome_usu;
	
	public UsuarioEntity dtoToEntity() {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setCodigo_usu(codigo_usu);
		usuarioEntity.setLogin_usu(login_usu);
		usuarioEntity.setNome_usu(nome_usu);
		usuarioEntity.setSenha_usu(senha_usu);
		
		return usuarioEntity;
	}
	
}
