package com.integrador.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.fornecedor.modelo.entity.FornecedorEntity;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity,Long>{
	
}
