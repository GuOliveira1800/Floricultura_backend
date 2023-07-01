package com.integrador.cliente.service;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.integrador.funcao;
import com.integrador.cliente.modelo.dto.ClienteDto;
import com.integrador.cliente.modelo.entity.ClienteEntity;
import com.integrador.cliente.repository.ClienteRepository;
import com.integrador.endereco.modelo.entity.EnderecoEntity;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public ResponseEntity<ClienteDto> inserir(ClienteDto cliente) throws Exception {
		
		ClienteEntity clienteEntity = new ClienteEntity();
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		
		JSONObject jsonCep = funcao.getInstance().buscaCep(cliente.getCep_end());
		
		if (jsonCep != null) {
			
			enderecoEntity.setCidade_end(jsonCep.getString("localidade"));
			enderecoEntity.setRua_end(jsonCep.getString("logradouro"));
			enderecoEntity.setUf_end(jsonCep.getString("uf"));
		}				
		enderecoEntity.setCep_end(cliente.getCep_end());
		
		clienteEntity.setCodigo_usu(cliente.getCodigo_cli());
		clienteEntity.setCodend_cli(enderecoEntity);		
		clienteEntity.setDocume_cli(cliente.getDocume_cli());
		clienteEntity.setNome_cli(cliente.getNome_cli());
		clienteEntity.setTelefo_cli(cliente.getTelefo_cli());
		clienteEntity.setFoto_cli(cliente.getFoto_cli());
		
		clienteRepository.save(clienteEntity);
		
		return new ResponseEntity<ClienteDto>(HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ClienteDto> atualizar(ClienteDto cliente) throws Exception {
		
		Optional<ClienteEntity> oClienteEntity = clienteRepository.findById(cliente.getCodigo_cli());
		
		if (oClienteEntity.isEmpty()) {
			return new ResponseEntity<ClienteDto>(HttpStatus.BAD_REQUEST);
		}
		
		ClienteEntity clienteEntity = oClienteEntity.get();
				
		clienteEntity.getCodend_cli().setCidade_end(cliente.getCidade_end());
		clienteEntity.getCodend_cli().setRua_end(cliente.getRua_end());
		clienteEntity.getCodend_cli().setUf_end(cliente.getUf_end());						
		clienteEntity.getCodend_cli().setCep_end(cliente.getCep_end());
						
		clienteEntity.setDocume_cli(cliente.getDocume_cli());
		clienteEntity.setNome_cli(cliente.getNome_cli());
		clienteEntity.setTelefo_cli(cliente.getTelefo_cli());
		clienteEntity.setFoto_cli(cliente.getFoto_cli());
		
		clienteRepository.save(clienteEntity);
		
		return new ResponseEntity<ClienteDto>(HttpStatus.ACCEPTED);
	}
	
	public java.util.List<ClienteEntity> listar(){		
		return clienteRepository.findAll();
	}
	
	public ClienteEntity listar(long codigoCliente){		
		Optional<ClienteEntity> opCliente = this.clienteRepository.findById(codigoCliente);
		
		if (opCliente.isEmpty()) {
			return null;
		}else {
			return opCliente.get();
		}
	}
	
	public ResponseEntity<ClienteDto> deletar(long codigoCliente){
		this.clienteRepository.deleteById(codigoCliente);		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	
}
