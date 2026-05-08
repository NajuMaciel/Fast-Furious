/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.service;

import br.naju.eti.Fast_Furious_Food.StatusPedido;
import br.naju.eti.Fast_Furious_Food.domain.model.Pedido;
import br.naju.eti.Fast_Furious_Food.repository.PedidoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service
public class PedidoService {
   
    @Autowired
    private PedidoRepository pedidoRepository;
    
    
    public Pedido criar (Pedido pedido) {
        
        pedido.setDtAberto (LocalDateTime.now());
        pedido.setStatus(StatusPedido.ABERTA);
        
        if (pedido.getListaItens() != null) {
            pedido.getListaItens().forEach(item -> item.setPedido(pedido));
        }
                
        return pedidoRepository.save(pedido);
    }
    
    
    
    public Optional<Pedido> atualizarStatus (Long id, StatusPedido novoStatus) {
        Optional<Pedido> optPedido = pedidoRepository.findById(id);
        
        if (optPedido.isEmpty()) {
            return optPedido;
        }
        
        Pedido pedidoAntigo = optPedido.get();
        
        if (novoStatus == StatusPedido.PRONTA && pedidoAntigo.getStatus() == StatusPedido.ABERTA) {
            pedidoAntigo.setStatus(StatusPedido.PRONTA);
            pedidoAntigo.setDtPronta(LocalDateTime.now());
        } else if (novoStatus == StatusPedido.FINALIZADA && pedidoAntigo.getStatus() != StatusPedido.PRONTA) {
            pedidoAntigo.setStatus(StatusPedido.FINALIZADA);
            pedidoAntigo.setDtCancelada(LocalDateTime.now());
        }else if (novoStatus == StatusPedido.CANCELADA && pedidoAntigo.getStatus() != StatusPedido.FINALIZADA) {
            pedidoAntigo.setStatus(StatusPedido.CANCELADA);
            pedidoAntigo.setDtCancelada(LocalDateTime.now());
        } else {
            throw new RuntimeException("Status" + novoStatus + " não pode ser aplicado em " + pedidoAntigo.getStatus().name());
        }
        
        
        
        optPedido = Optional.of(pedidoRepository.save(pedidoAntigo));
        return optPedido;
        
        
        
    }
    
    public void excluir (Long pedidoId){
        pedidoRepository.deleteById (pedidoId);
    }
}
