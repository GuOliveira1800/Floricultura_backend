package com.integrador.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.cliente.modelo.dto.ClienteDto;
import com.integrador.produto.modelo.dto.ProdutoDto;
import com.integrador.produto.modelo.entity.ProdutoEntity;
import com.integrador.produto.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private  ProdutoService produtoService = new ProdutoService();
	
	@PostMapping("/inserir")
	public ResponseEntity<ProdutoDto> inserir(@RequestBody ProdutoDto cliente) throws Exception {
		return produtoService.inserir(cliente);
	}
	
	@GetMapping("/deletar/{codigoCliente}")
	public ResponseEntity<ProdutoDto> deletar(@PathVariable int codigoCliente) throws Exception {
		return produtoService.deletar(codigoCliente);
	}
	
	@GetMapping("/listar/{index}")
	public List<ProdutoDto> listar(@PathVariable int index){
		System.out.println("teste");
		return produtoService.listar(index);		
	}

	@GetMapping("/procura/{nome}")
	public List<ProdutoDto> listar(@PathVariable String nome){
		return produtoService.listarPorNome(nome);
	}
	
	@GetMapping("/listar/unico/{codigoCliente}")
	public ProdutoEntity listar(@PathVariable long codigoCliente){		
		return produtoService.listarUnico(codigoCliente);
	}
	
}
