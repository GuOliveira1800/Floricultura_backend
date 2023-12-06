package com.integrador.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.usuario.modelo.dto.UsuarioDto;
import com.integrador.usuario.modelo.entity.UsuarioEntity;
import com.integrador.usuario.modelo.principal.Usuario;
import com.integrador.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {"http://192.168.1.22:19000/"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioEntity> validar(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		return usuarioService.validar(usuario);
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDto usuario) {			
		return usuarioService.salvar(usuario);
	}
	
	@GetMapping("/pegar/{codigo}")
	public UsuarioEntity salvar(@PathVariable Long codigo) {			
		return usuarioService.getUsuario(codigo);
	}
	
}
