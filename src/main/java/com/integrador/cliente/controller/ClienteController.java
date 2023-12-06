package com.integrador.cliente.controller;

import java.util.List;
import java.util.stream.Stream;

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
import com.integrador.cliente.modelo.entity.ClienteEntity;
import com.integrador.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = {"http://192.168.1.22:19000/"})
public class ClienteController {
	
	@Autowired
	private  ClienteService serviceCliente = new ClienteService();
	
	@PostMapping("/inserir")
	public ResponseEntity<ClienteDto> inserir(@RequestBody ClienteDto cliente) throws Exception {
		return serviceCliente.inserir(cliente);
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<ClienteDto> atualizar(@RequestBody ClienteDto cliente) throws Exception {
		return serviceCliente.atualizar(cliente);
	}
	
	@GetMapping("/deletar/{codigoCliente}")
	public ResponseEntity<ClienteDto> deletar(@PathVariable int codigoCliente) throws Exception {
		return serviceCliente.deletar(codigoCliente);
	}
	
	@GetMapping("/listar")
	public List<ClienteEntity> listar(){
		System.out.println("teste");
		return serviceCliente.listar();		
	}
	
	@GetMapping("/listar/{codigoCliente}")
	public ClienteEntity listar(@PathVariable long codigoCliente){		
		return serviceCliente.listar(codigoCliente);
	}

	@GetMapping("/listar/nome/{nomeCliente}")
	public Stream<ClienteEntity> listar(@PathVariable String nomeCliente){
		return serviceCliente.listaPorNome(nomeCliente);
	}

	
}
