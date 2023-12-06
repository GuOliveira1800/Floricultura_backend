package com.integrador.entrada.modelo.entity;

import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;
import com.integrador.produto.modelo.entity.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "entrada")
@Table(name="entrada",schema = "integrador")
public class EntradaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , unique = true)
	private Long codigo_ent;

	@Column(name="quanti_ent")
	private int quanti_ent;
	
	@Column(name="valuni_ent")
	private float valuni_ent;

	@Column(name="datent_ent")
	private Date datent_ent;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codprd_ent", referencedColumnName = "id")
	private ProdutoEntity codprd_ent;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codfor_ent", referencedColumnName = "id")
	private FornecedorEntity codfor_ent;
}
