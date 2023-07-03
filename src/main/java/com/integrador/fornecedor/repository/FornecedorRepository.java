package com.integrador.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.integrador.fornecedor.modelo.entity.FornecedorEntity;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FornecedorRepository extends JpaRepository<FornecedorEntity,Long>{
	public List<FornecedorEntity> findByNomeForContains(String nome_for);
}
