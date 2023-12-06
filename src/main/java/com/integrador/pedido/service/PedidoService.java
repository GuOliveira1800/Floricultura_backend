package com.integrador.pedido.service;

import com.integrador.cliente.modelo.entity.ClienteEntity;
import com.integrador.cliente.repository.ClienteRepository;
import com.integrador.pedido.modelo.dto.PedidoDto;
import com.integrador.pedido.modelo.dto.PedidoProdutoDto;
import com.integrador.pedido.modelo.entity.PedidoEntity;
import com.integrador.pedido.modelo.entity.PedidoProdutoEntity;
import com.integrador.pedido.modelo.repository.PedidoProdutoRepository;
import com.integrador.pedido.modelo.repository.PedidoRepository;
import com.integrador.produto.modelo.dto.ProdutoDto;
import jakarta.persistence.Entity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoProdutoRepository pedidoProdutoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public Stream<PedidoDto> listar(int index) {
        return this.pedidoRepository.findAll().stream().map(reg -> {
           return reg.entToDto();
        });
    }
    public PedidoProdutoDto listarUnico(Long codigoPedido) {

        List<PedidoProdutoEntity> lista = this.pedidoProdutoRepository.findBycodigo(codigoPedido);
        PedidoProdutoDto pedidoProdutoDto = null;

        List<ProdutoDto> listaPrd = new ArrayList<>();

        for (PedidoProdutoEntity reg: lista) {
            listaPrd.add(reg.getCodprd_ppd().entTodto(reg.getQuanti_ppd()));
        }

        pedidoProdutoDto = new PedidoProdutoDto(
                lista.get(0).getId(),
                lista.get(0).getCodped_ppd().entToDto(),
                listaPrd,
                lista.get(0).getQuanti_ppd()
        );

        return pedidoProdutoDto;
    }

    public ResponseEntity AtualizaStatusPedido(Long codigoPedido, Long novoStatus){
        Optional<PedidoEntity> pedidoEntity = this.pedidoRepository.findById(codigoPedido);

        if (pedidoEntity.isPresent() && !pedidoEntity.isEmpty()){
            PedidoEntity pedido = pedidoEntity.get();
            pedido.setStatus_ped(novoStatus);
            this.pedidoRepository.save(pedido);
        }else{
            return ResponseEntity.badRequest().body("Pedido não achado!!");
        }

        return ResponseEntity.ok("Atualizado com sucesso!!");
    }

    public ResponseEntity registrar(PedidoProdutoDto pedidoProdutoDto){

        PedidoEntity pedidoEntity = pedidoProdutoDto.getCodigoPedido().toEntity();

        ClienteEntity cliente = clienteRepository.getById(pedidoProdutoDto.getCodigoPedido().getId());

        pedidoEntity.setCodcli_ped(cliente);

        this.pedidoRepository.save(pedidoEntity);

        PedidoProdutoEntity pedidoProdutoEntity = null;

        System.out.println(pedidoProdutoDto.getCodigoProduto().size());

        for (ProdutoDto reg: pedidoProdutoDto.getCodigoProduto()) {

            pedidoProdutoEntity = new PedidoProdutoEntity();

            if (pedidoEntity.getId() != null){
                Optional<PedidoProdutoEntity> valida = this.pedidoProdutoRepository.findByPedPro(pedidoEntity.getId(),reg.getId());

                if (valida.isPresent() || !valida.isEmpty()){
                    pedidoProdutoEntity.setId(valida.get().getId());
                }
            }

            pedidoProdutoEntity.setCodped_ppd(pedidoEntity);
            pedidoProdutoEntity.setCodprd_ppd(reg.toEntity());
            pedidoProdutoEntity.setQuanti_ppd(reg.getQtd_prd());

            this.pedidoProdutoRepository.save(pedidoProdutoEntity);
        }

        return ResponseEntity.ok("Registrado com sucesso!!");
    }

    public ResponseEntity deletarProduto (Long codigoPedido, Long codigoProduto){
        Optional<PedidoProdutoEntity> valida = this.pedidoProdutoRepository.findByPedPro(codigoPedido,codigoProduto);

        if (valida.isPresent() && !valida.isEmpty()){
            this.pedidoProdutoRepository.delete(valida.get());
        }

        return ResponseEntity.ok("Produto Removido com sucesso!!");
    }

}
