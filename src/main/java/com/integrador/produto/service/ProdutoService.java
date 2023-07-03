package com.integrador.produto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.integrador.cliente.modelo.dto.ClienteDto;
import com.integrador.produto.modelo.dto.ProdutoDto;
import com.integrador.produto.modelo.entity.ProdutoEntity;
import com.integrador.produto.modelo.repository.ProdutoCustomRepository;
import com.integrador.produto.modelo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ProdutoCustomRepository produtoCustomRepository;
	
	public ResponseEntity<ProdutoDto> inserir(ProdutoDto produto) throws Exception {
		
		produtoRepository.save(produto.toEntity());
		
		return new ResponseEntity<ProdutoDto>(HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ProdutoDto> atualizar(ProdutoDto produto) throws Exception {
		
		produtoRepository.save(produto.toEntity());
		
		return new ResponseEntity<ProdutoDto>(HttpStatus.ACCEPTED);
	}
	
	public java.util.List<ProdutoDto> listar(int index){		
		return produtoCustomRepository.getPagina(index);
	}

	public java.util.List<ProdutoDto> listarPorNome(String nome){
		List<ProdutoDto> lista = produtoCustomRepository.getPorNome(nome);
		return lista;
	}
	
	public ProdutoEntity listarUnico(long codigoCliente){		
		Optional<ProdutoEntity> opCliente = this.produtoRepository.findById(codigoCliente);
		
		if (opCliente.isEmpty()) {
			return null;
		}else {
			return opCliente.get();
		}
	}
	
	public ResponseEntity<ProdutoDto> deletar(long codigoCliente){
		this.produtoRepository.deleteById(codigoCliente);		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
