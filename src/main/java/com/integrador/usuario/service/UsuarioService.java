package com.integrador.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.integrador.usuario.modelo.dto.UsuarioDto;
import com.integrador.usuario.modelo.entity.UsuarioEntity;
import com.integrador.usuario.modelo.principal.Usuario;
import com.integrador.usuario.modelo.repository.UsuarioCustomRepository;
import com.integrador.usuario.modelo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired	
	private UsuarioCustomRepository customRepository;
	
	public Long validar(Usuario usuario) {
				
		List<UsuarioEntity> codigo =  this.customRepository.validar(usuario.getLogin_usu(), usuario.getSenha_usu());
		
		if(codigo.size() > 0) {
			System.out.println(codigo.get(0).getCodigo_usu());
			return codigo.get(0).getCodigo_usu();
		}else{
			return null;
		}
	}
	
	public ResponseEntity<Usuario> salvar(UsuarioDto usuario) {
		
		UsuarioEntity usuarioEntity = usuario.dtoToEntity();
		
		usuarioRepository.save(usuarioEntity);
		
		return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
	}
	
	public UsuarioEntity getUsuario(long codigo) {
		
		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(codigo);
		
		if(usuarioEntity.isPresent()) {
			return usuarioEntity.get();
		}else {
			return null;
		}
				
	}
	
}
