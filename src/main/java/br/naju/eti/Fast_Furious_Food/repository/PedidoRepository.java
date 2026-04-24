/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.repository;

import br.naju.eti.Fast_Furious_Food.domain.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sesi3dia
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido>findByCpf (String cpf); //busca o pedido pelo cpf
    List<Pedido>findByClienteContainingIgnoreCase (String cliente);//busa pelo nome do cliente e o "ignore case" evita erros de digitação (por exemploletras miusculas e minusculas)
    List<Pedido>findByStatus (String status); //busca pelo status do pedido
    
    
}
