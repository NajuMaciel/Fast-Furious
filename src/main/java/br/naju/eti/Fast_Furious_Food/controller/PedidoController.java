/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.controller;

import br.naju.eti.Fast_Furious_Food.StatusPedido;
import br.naju.eti.Fast_Furious_Food.domain.model.Pedido;
import br.naju.eti.Fast_Furious_Food.dto.AtualizaStatusDTO;
import br.naju.eti.Fast_Furious_Food.repository.PedidoRepository;
import br.naju.eti.Fast_Furious_Food.service.PedidoService;
import ch.qos.logback.core.status.Status;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */
@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PedidoService pedidoService;
    
    //get pedido
    @GetMapping("/pedido")
    public List<Pedido> Listas () {
        return pedidoRepository.findAll();
    }
    
    //get pedido ID
    @GetMapping("/pedido/{pedidoId}")
    
    public ResponseEntity<Pedido> buscar(@PathVariable Long pedidoId) {

        Optional<Pedido> produto = pedidoRepository.findById(pedidoId);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //POST pedido
    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar(@Valid @RequestBody Pedido pedido) {

        return pedidoService.criar(pedido);
    }
    
    //PUT pedido ID
    @PutMapping("/pedido/{pedidoId}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long pedidoId, @Valid @RequestBody Pedido pedido) {

        if (!pedidoRepository.existsById(pedidoId)) {
            return ResponseEntity.notFound().build();
        }

        pedido.setId(pedidoId);
        pedido = pedidoService.criar(pedido);
        return ResponseEntity.ok(pedido);
    }
    
    //DELETE pedido ID
    @DeleteMapping("/pedido/{pedidoId}")
    public ResponseEntity<Void> excluir(@PathVariable Long pedidoId) {

        if (!pedidoRepository.existsById(pedidoId)) {
            return ResponseEntity.notFound().build();
        }

        pedidoService.excluir(pedidoId);
        return ResponseEntity.noContent().build();
    }
    
    //PUT status
    @PutMapping ("/pedido/atualizastatus/{pedidoId}")
    public ResponseEntity<Pedido> atualizaStatus (@Valid @PathVariable Long pedidoID,
            @RequestBody AtualizaStatusDTO atualizaStatusDTO) {
        
        Optional<Pedido> optPedido = pedidoService.atualizarStatus(pedidoID, atualizaStatusDTO.status());
        
        if (optPedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(optPedido.get());
    }
    
    //GET status
    @GetMapping ("/pedido/status/{status}")
    public ResponseEntity<List <Pedido>> buscar (@PathVariable StatusPedido status) {
        List<Pedido> pedido = pedidoRepository.findByStatus(status);
        
        if (pedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pedido);
        }
    }
    
}
