package com.teste.restful.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.restful.model.ProdutoModel;

@Repository
public class ProdutoRepository {

	private ArrayList<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
	private Integer id = 0;
	
	/**
	 * Método para retornar todos os produtos
	 * @param
	 * @return List<ProdutoModel> - lista de produtos
	 */
	public List<ProdutoModel> findAll() {
		return produtos;
	}
	
	/**
	 * Método para retornar um produto pelo id
	 * 
	 * @param id - id do produto
	 * @return Optional<ProdutoModel> - produto
	 */
	public Optional<ProdutoModel> findById(Integer id) {
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
	public ProdutoModel save(ProdutoModel produto) {
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
	public ProdutoModel update(ProdutoModel produto) {
		Optional<ProdutoModel> produtoOptional = findById(produto.getId());
		
		if(produtoOptional.isEmpty()) {
			throw new InputMismatchException("Produto não encontrado");
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
