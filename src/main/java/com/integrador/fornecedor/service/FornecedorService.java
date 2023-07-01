package com.integrador.fornecedor.service;

import java.util.Iterator;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.integrador.funcao;
import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.fornecedor.modelo.dto.FornecedorDto;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;
import com.integrador.fornecedor.repository.FornecedorRepository;
import com.integrador.produto.service.ProdutoService;

@Service
public class FornecedorService {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	public ResponseEntity<FornecedorDto> inserir(FornecedorDto fornecedor) throws Exception {
		
		FornecedorEntity fornecedorEntity = null;		
		
		System.out.println(fornecedor.getNome_for());
		
		if(fornecedor.getCodigo_for() == null) {
			fornecedorEntity = fornecedor.dtoToEntity();
		}else {
			Optional<FornecedorEntity> opFornecedor = this.fornecedorRepository.findById(fornecedor.getCodigo_for());
			
			if(!opFornecedor.isEmpty()) {
				fornecedorEntity = opFornecedor.get();
				
				fornecedorEntity = fornecedor.dtoToEntity(fornecedorEntity);
			}else {
				return new ResponseEntity<FornecedorDto>(HttpStatus.BAD_REQUEST);
			}
		}
		System.out.println(fornecedorEntity.getCodend_for().getCep_end());
		
		JSONObject jsonCep = funcao.getInstance().buscaCep(fornecedorEntity.getCodend_for().getCep_end());
		
		if (jsonCep != null) {
			
			fornecedorEntity.getCodend_for().setCidade_end(jsonCep.getString("localidade"));
			fornecedorEntity.getCodend_for().setRua_end(jsonCep.getString("logradouro"));
			fornecedorEntity.getCodend_for().setUf_end(jsonCep.getString("uf"));
		}				
		fornecedorEntity.getCodend_for().setCep_end(fornecedor.getCep_end());		
		
		fornecedorRepository.save(fornecedorEntity);
		
		return new ResponseEntity<FornecedorDto>(HttpStatus.ACCEPTED);
	}
	
	public java.util.List<FornecedorEntity> listar(){		
		return fornecedorRepository.findAll();
	}
	
	public FornecedorEntity listar(long codigoFornecedor){		
		Optional<FornecedorEntity> opFornecedor = this.fornecedorRepository.findById(codigoFornecedor);
		
		if (opFornecedor.isEmpty()) {
			return null;
		}else {
			return opFornecedor.get();
		}
	}
	
	public ResponseEntity<FornecedorDto> deletar(long codigoFornecedor){
		this.fornecedorRepository.deleteById(codigoFornecedor);		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	
}
