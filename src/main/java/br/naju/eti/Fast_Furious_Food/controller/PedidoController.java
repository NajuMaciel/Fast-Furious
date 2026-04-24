/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.controller;

import br.naju.eti.Fast_Furious_Food.domain.model.Pedido;
import br.naju.eti.Fast_Furious_Food.repository.PedidoRepository;
import br.naju.eti.Fast_Furious_Food.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    //
}
