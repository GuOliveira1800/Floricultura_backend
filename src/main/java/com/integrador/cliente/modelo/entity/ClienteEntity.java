package com.integrador.cliente.modelo.entity;

import com.integrador.cliente.modelo.dto.ClienteDto;
import com.integrador.endereco.modelo.entity.EnderecoEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "cliente")
@Table(name="cliente",schema = "integrador")
public class ClienteEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , unique = true)
	private Long codigo_usu;
	
	@Column(name="nome_cli")
	private String nome_cli;
	
	@Column(name="docume_cli")
	private String docume_cli;
	
	@Column(name="telefo_cli")
	private String telefo_cli;
	
	@Column(name="foto_cli")
	private byte[] foto_cli;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codend_cli", referencedColumnName = "id")
	private EnderecoEntity codend_cli;

	public ClienteDto entToDto(){
		return new ClienteDto(this.codigo_usu,this.nome_cli,this.docume_cli,this.codend_cli.getCep_end(),this.telefo_cli,this.foto_cli);
	}
	
}
