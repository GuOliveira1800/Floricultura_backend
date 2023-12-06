package com.integrador.entrada.controller;

import com.integrador.entrada.modelo.dto.EntradaDto;
import com.integrador.entrada.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrada")
@CrossOrigin(origins = {"http://192.168.1.22:19000/"})
public class EntradaController {
	
	@Autowired
	private EntradaService entradaService = new EntradaService();
	
	@PostMapping("/salvar")
	public ResponseEntity<EntradaDto> inserir(@RequestBody EntradaDto entradaDto) throws Exception {
		return entradaService.inserir(entradaDto);
	}

}
