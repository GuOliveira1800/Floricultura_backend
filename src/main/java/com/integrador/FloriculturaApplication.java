package com.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages= {
		"com.integrador.usuario.modelo",
		"com.integrador.usuario.service",
		"com.integrador.usuario.controller",
		"com.integrador.cliente.modelo",
		"com.integrador.cliente.service",
		"com.integrador.cliente.controller",
		"com.integrador.produto.modelo",
		"com.integrador.produto.service",
		"com.integrador.produto.controller",
		"com.integrador.fornecedor.modelo",
		"com.integrador.fornecedor.service",
		"com.integrador.fornecedor.controller",
		"com.integrador.entrada.modelo",
		"com.integrador.entrada.service",
		"com.integrador.entrada.controller",
		"com.integrador.pedido.modelo",
		"com.integrador.pedido.service",
		"com.integrador.pedido.controller"
})

public class FloriculturaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FloriculturaApplication.class, args);
	}



}
