package com.integrador.fornecedor.controller;

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

import com.integrador.fornecedor.modelo.dto.FornecedorDto;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;
import com.integrador.fornecedor.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
@CrossOrigin(origins = {"http://192.168.1.31:19000/","http://192.168.1.31:19000/","http://192.168.1.31:19000/"})
public class FornecedorController {
	
	@Autowired
	private  FornecedorService fornecedorService = new FornecedorService();
	
	@PostMapping("/salvar")
	public ResponseEntity<FornecedorDto> inserir(@RequestBody FornecedorDto fornecedor) throws Exception {
		return fornecedorService.inserir(fornecedor);
	}
	
	@GetMapping("/deletar/{codigoFornecedor}")
	public ResponseEntity<FornecedorDto> deletar(@PathVariable int codigoFornecedor) throws Exception {
		return fornecedorService.deletar(codigoFornecedor);
	}
	
	@GetMapping("/listar")
	public List<FornecedorEntity> listar(){
		return fornecedorService.listar();		
	}
	
	@GetMapping("/listar/{codigoFornecedor}")
	public FornecedorEntity listar(@PathVariable long codigoFornecedor){		
		return fornecedorService.listar(codigoFornecedor);
	}

	
}
