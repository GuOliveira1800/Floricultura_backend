package com.integrador.produto.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.integrador.produto.modelo.dto.ProdutoDto;
import com.integrador.usuario.modelo.principal.Usuario;

import jakarta.persistence.EntityManager;

@Repository
public class ProdutoCustomRepository {

	private final EntityManager em;


    ProdutoCustomRepository(EntityManager em) {
        this.em = em;
    }
	
	
	public List<ProdutoDto> getPagina(int index) {

        String query = "";
        if(index == 1) {
        	query = "select P from produto as P order by P.id desc limit 10";
        }else {
        	query = "select * from produto where P.codigo_prd > "+index+" order by P.id limit 10";
        }
        
        var q = em.createQuery(query, ProdutoDto.class);

        return q.getResultList();
    }

    public List<ProdutoDto> getPorNome(String nome) {

        String query = "select P from produto as P where nome_prd like '%"+nome+"%' order by P.id desc";

        var q = em.createQuery(query, ProdutoDto.class);

        return q.getResultList();
    }
	
}
