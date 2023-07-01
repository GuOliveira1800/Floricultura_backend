package com.integrador.usuario.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.integrador.usuario.modelo.entity.UsuarioEntity;
import com.integrador.usuario.modelo.principal.Usuario;

import jakarta.persistence.EntityManager;

@Repository
public class UsuarioCustomRepository {

	private final EntityManager em;


    UsuarioCustomRepository(EntityManager em) {
        this.em = em;
    }
	
	
	public List<UsuarioEntity> validar(String login, String senha) {

        String query = "select U from usuario as U ";
        String condicao = "where";

        if(login != null) {
            query += condicao + " U.login_usu = :login";
            condicao = " and ";
        }
        
        if(login != null) {
            query += condicao + " U.senha_usu = :senha";            
        }

        var q = em.createQuery(query, UsuarioEntity.class);

        if(login != null) {
            q.setParameter("login", login.toLowerCase());
        }
        
        if(senha != null) {
            q.setParameter("senha", senha.toLowerCase());
        }

        return q.getResultList();
    }
	
}
