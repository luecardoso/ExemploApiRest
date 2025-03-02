package com.teste.restful.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.restful.model.ProdutoModel;
import com.teste.restful.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	/**
	 * Método para retornar todos os produtos
	 * 
	 * @param
	 * @return List<ProdutoModel> - lista de produtos
	 */
	@GetMapping
	public List<ProdutoModel> findAll() {
		return produtoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ProdutoModel> findById(@PathVariable Integer id) {
		return produtoService.findById(id);
	}
	
	@PostMapping
	public ProdutoModel save(@RequestBody ProdutoModel produto) {
		return produtoService.save(produto);
	}
	
	@PutMapping("/{id}")
	public ProdutoModel update(@PathVariable Integer id, @RequestBody ProdutoModel produto) {
		return produtoService.update(id, produto);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		produtoService.delete(id);
	}
}
