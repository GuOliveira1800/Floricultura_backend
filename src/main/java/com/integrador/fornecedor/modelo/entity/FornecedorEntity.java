package com.integrador.fornecedor.modelo.entity;

import java.util.List;

import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.produto.modelo.entity.ProdutoEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "fornecedor")
@Table(name="fornecedor",schema = "integrador")
public class FornecedorEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , unique = true)
	private Long codigo_for;
	
	@Column(name="nome_for")
	private String nomeFor;
	
	@Column(name="docume_for")
	private String docume_for;
	
	@Column(name="telefo_for")
	private String telefo_for;
	
	@Column(name="foto_for")
	private byte[] foto_for;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codend_for", referencedColumnName = "id")
	private EnderecoEntity codend_for;

	
}
