package com.integrador.entrada.repository;

import com.integrador.entrada.modelo.entity.EntradaEntity;
import com.integrador.fornecedor.modelo.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EntradaRepository extends JpaRepository<EntradaEntity,Long>{

}
