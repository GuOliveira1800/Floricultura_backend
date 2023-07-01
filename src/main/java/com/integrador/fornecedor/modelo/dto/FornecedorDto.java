package com.integrador.fornecedor.modelo.dto;

import java.util.List;

import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDto {

	private Long codigo_for;
	private String nome_for;
	private String docume_for;
	private String cep_end;	
	private String telefo_for;
	private String cidade_end;
	private String uf_end;
	private String rua_end;
	private byte[] foto_for;
	
	public FornecedorEntity dtoToEntity() {
		FornecedorEntity fornecedorEntity = new FornecedorEntity();
		
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		
		fornecedorEntity.setCodigo_for(this.codigo_for);
		fornecedorEntity.setDocume_for(this.docume_for);
		fornecedorEntity.setNome_for(this.nome_for);
		fornecedorEntity.setTelefo_for(this.telefo_for);
		fornecedorEntity.setFoto_for(this.foto_for);
		fornecedorEntity.setCodend_for(enderecoEntity);		
		fornecedorEntity.getCodend_for().setCep_end(this.cep_end);
		
		
		return fornecedorEntity;
	}
	
	public FornecedorEntity dtoToEntity(FornecedorEntity fornecedorEntity) {
		
		fornecedorEntity.setDocume_for(this.docume_for);
		fornecedorEntity.setNome_for(this.nome_for);
		fornecedorEntity.setTelefo_for(this.telefo_for);
		fornecedorEntity.setFoto_for(this.foto_for);
		
		return fornecedorEntity;
	}
	
}
