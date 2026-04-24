/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.repository;

import br.naju.eti.Fast_Furious_Food.domain.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sesi3dia
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{    
    
    List<Produto> findByNome (String nome); //busca pelo nome completo do cliente
    List<Produto> findByNomeContaining(String nome); //busca por alguma parte do nome (pode ser so o sobrenome)
    List<Produto> findByCategoria(String categoria);
}
