package com.integrador.usuario.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "usuario")
@Table(name="usuario",schema = "integrador")
public class UsuarioEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_usu" , unique = true)
	private Long codigo_usu;
	
	@Column(name="login_usu")
	private String login_usu;
	
	@Column(name="senha_usu")
	private String senha_usu;
	
	@Column(name="nome_usu")
	private String nome_usu;
}
