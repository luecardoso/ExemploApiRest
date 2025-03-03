package com.teste.restful.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.restful.model.Produto;
import com.teste.restful.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepositoryOLD {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Integer id = 0;
	
	/**
	 * Método para retornar todos os produtos
	 * @param
	 * @return List<ProdutoModel> - lista de produtos
	 */
	public List<Produto> findAll() {
		return produtos;
	}
	
	/**
	 * Método para retornar um produto pelo id
	 * 
	 * @param id - id do produto
	 * @return Optional<ProdutoModel> - produto
	 */
	public Optional<Produto> findById(Integer id) {
		return produtos
				.stream()
				.filter(produto -> produto.getId() == id)
				.findFirst();
	}
	
	/**
	 * Método para salvar um produto
	 * 
	 * @param  produto - produto a ser salvo
	 * @return ProdutoModel - produto salvo
	 */
	public Produto save(Produto produto) {
		id++;
		produto.setId(id);
        produtos.add(produto);
        return produto;
	}
	
	/**
	 * Método para atualizar um produto existente
	 * @param produto - produto a ser atualizado
	 * @return
	 */
	public Produto update(Produto produto) {
		Optional<Produto> produtoOptional = findById(produto.getId());
		
		if(produtoOptional.isEmpty()) {
			throw new ResourceNotFoundException("Produto não encontrado");
		}

		deleteById(produto.getId());
		produtos.add(produto);
		return produto;
	}
	
	/**
	 * Método para deletar um produto
	 * @param id - id do produto a ser deletado
	 */
	public void deleteById(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
	}
	
}
