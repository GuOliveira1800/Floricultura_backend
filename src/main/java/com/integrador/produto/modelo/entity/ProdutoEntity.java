package com.integrador.produto.modelo.entity;

import com.integrador.endereco.modelo.entity.EnderecoEntity;

import com.integrador.produto.modelo.dto.ProdutoDto;
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
@Entity(name = "produto")
@Table(name="produto",schema = "integrador")
public class ProdutoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , unique = true)
	private Long id;
	
	@Column(name="nome_prd")
	private String nome_prd;
	
	@Column(name="descri_prd")
	private String descri_prd;
	
	@Column(name="qtd_prd")
	private Long qtd_prd;
	
	@Column(name="valuni_prd")
	private Double valuni_prd;
	
	@Column(name="foto_prd")
	private byte[] foto_prd;

	public ProdutoDto entTodto(Long qtd){
		return new ProdutoDto(this.id, this.nome_prd, this.descri_prd, qtd, this.valuni_prd, this.foto_prd);
	}
	
}
