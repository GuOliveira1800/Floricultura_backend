package com.integrador.entrada.service;

import com.integrador.endereco.modelo.entity.EnderecoEntity;
import com.integrador.entrada.modelo.dto.EntradaDto;
import com.integrador.entrada.modelo.entity.EntradaEntity;
import com.integrador.entrada.repository.EntradaRepository;
import com.integrador.fornecedor.modelo.dto.FornecedorDto;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;
import com.integrador.fornecedor.repository.FornecedorRepository;
import com.integrador.fornecedor.service.FornecedorService;
import com.integrador.funcao;
import com.integrador.produto.modelo.entity.ProdutoEntity;
import com.integrador.produto.service.ProdutoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	FornecedorService fornecedorService;


	public ResponseEntity<EntradaDto> inserir(EntradaDto entradaDto) throws Exception {

		EntradaEntity entradaEntity = new EntradaEntity();

		entradaEntity.setValuni_ent(entradaDto.getValuni_ent());
		entradaEntity.setQuanti_ent(entradaDto.getQuanti_ent());
		entradaEntity.setDatent_ent(entradaDto.getDatent_ent());

		System.out.println( entradaDto.getCodprd_ent().getId() );

		entradaEntity.setCodprd_ent(produtoService.listarUnico(entradaDto.getCodprd_ent().getId() ));

		entradaEntity.getCodprd_ent().setQtd_prd( entradaEntity.getCodprd_ent().getQtd_prd() + entradaDto.getQuanti_ent() );

		entradaEntity.setCodfor_ent(fornecedorService.listar(entradaDto.getCodfor_ent().getCodigo_for()));
		entradaEntity.setCodigo_ent(null);

		entradaRepository.save(entradaEntity);
		
		return new ResponseEntity<EntradaDto>(HttpStatus.ACCEPTED);
	}

}
