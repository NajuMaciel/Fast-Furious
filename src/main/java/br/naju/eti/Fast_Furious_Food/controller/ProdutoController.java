/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.naju.eti.Fast_Furious_Food.controller;


import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import org.springframework.beans.factory.annotation.Autowired;

import br.naju.eti.Fast_Furious_Food.repository.ProdutoRepository;

import br.naju.eti.Fast_Furious_Food.service.ProdutoService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.naju.eti.Fast_Furious_Food.domain.model.Produto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */

//controller é quem cuida da comunicação, ele cuida do mapeamento http, e conversa como json pelos metodods get, put, delete e post.
@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    //GET PRODUTO:
     @GetMapping ("/produto")
    
    public List<Produto> listas (){
        return produtoRepository.findAll();
    }
    
    
    //GET ID - busca, ele entrega o resultado
    @GetMapping("/produto/{produtoId}")
    
    public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) {

        Optional<Produto> produto = produtoRepository.findById(produtoId);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // GET categoria
     @GetMapping("/produto/cat/{categoria}")
    
    public ResponseEntity<Produto> buscarCat(@PathVariable Long categoria) {

        Optional<Categoria> categoria = produtoRepository.findById(categoria);

        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   // POST PRODUTO - add
    
    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@Valid @RequestBody Produto produto) {

        return produtoService.criar(produto);
    }
    
    //PUT PRODUTO ID - altera a informação 
    
    @PutMapping("/produto/{produtoId}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long produtoId, @Valid @RequestBody Produto produto) {

        if (!produtoRepository.existsById(produtoId)) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(produtoId);
        produto = produtoService.criar(produto);
        return ResponseEntity.ok(produto);
    }
    
    //DELETE produto - ele exclui de acordo com o id
    @DeleteMapping("/produto/{produtoId}")
    public ResponseEntity<Void> excluir(@PathVariable Long produtoId) {

        if (!produtoRepository.existsById(produtoId)) {
            return ResponseEntity.notFound().build();
        }

        produtoService.excluir(produtoId);
        return ResponseEntity.noContent().build();
    }
    
    //para o PUT e DEL, colocar o id do produto no endereço: http://localhost:8080/produto/ID , assim ele altera o produto certo.
}

