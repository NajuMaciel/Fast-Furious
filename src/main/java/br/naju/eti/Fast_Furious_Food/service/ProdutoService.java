/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.service;

import br.naju.eti.Fast_Furious_Food.domain.model.Produto;
import br.naju.eti.Fast_Furious_Food.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */

//implementa as regras de negócio - em que situação o produto pode ser cadastrado

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto criar (Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public void excluir (Long produtoId) {
        produtoRepository.deleteById (produtoId);
    }
}
        