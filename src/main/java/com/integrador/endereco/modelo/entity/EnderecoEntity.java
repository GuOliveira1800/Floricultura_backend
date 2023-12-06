package com.integrador.endereco.modelo.entity;

import com.integrador.endereco.modelo.dto.EnderecoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "endereco")
@Table(name="endereco",schema = "integrador")
public class EnderecoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , unique = true)
	private Long codigo_end;
	
	@Column(name="cep_end")
	private String cep_end;

	@Column(name="uf_end")
	private String uf_end;

	@Column(name="cidade_end")
	private String cidade_end;

	@Column(name="rua_end")
	private String rua_end;

	public EnderecoDto entToDto(){
		return new EnderecoDto(this.codigo_end,this.cep_end,this.uf_end,this.cidade_end,this.uf_end);
	}

}
