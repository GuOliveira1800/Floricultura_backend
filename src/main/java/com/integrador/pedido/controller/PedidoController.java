package com.integrador.pedido.controller;

import com.integrador.pedido.modelo.dto.PedidoDto;
import com.integrador.pedido.modelo.dto.PedidoProdutoDto;
import com.integrador.pedido.modelo.entity.PedidoProdutoEntity;
import com.integrador.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = {"http://192.168.1.22:19000/"})
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/listar")
    public Stream<PedidoDto> listar(){
        return pedidoService.listar(1);
    }

    @GetMapping("/listar/unico/{codigoPedido}")
    public PedidoProdutoDto listar(@PathVariable Long codigoPedido){
        return pedidoService.listarUnico(codigoPedido);
    }

    @PostMapping("/salva")
    public ResponseEntity salva(@RequestBody PedidoProdutoDto pedidoProdutoDto){
        return pedidoService.registrar(pedidoProdutoDto);
    }

    @GetMapping("/remover/{codigoPedido}/{codigoProduto}")
    public ResponseEntity deletarProduto(@PathVariable Long codigoPedido,@PathVariable Long codigoProduto){
        return pedidoService.deletarProduto(codigoPedido,codigoProduto);
    }

    @GetMapping("/atualiza/{codigoPedido}/{statusNovo}")
    public ResponseEntity atualizaStatusPedido(@PathVariable Long codigoPedido,@PathVariable Long statusNovo){
        return pedidoService.AtualizaStatusPedido(codigoPedido,statusNovo);
    }

}
