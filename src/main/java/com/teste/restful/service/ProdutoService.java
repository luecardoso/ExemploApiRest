package com.teste.restful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.restful.model.ProdutoModel;
import com.teste.restful.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	/**
	 * Método para retornar todos os produtos
	 * 
	 * @param
	 * @return List<ProdutoModel> - lista de produtos
	 */
	public List<ProdutoModel> findAll() {
	    return produtoRepository.findAll();
    }
	
	
	/**
	 * Método para retornar um produto pelo id
	 * 
	 * @param id - id do produto
	 * @return ProdutoModel - produto
	 */
	public Optional<ProdutoModel> findById(Integer id) {
		return produtoRepository.findById(id);
	}
	
	
	/**
	 * Método para salvar um produto
	 * 
	 * @param produto - produto a ser salvo
	 * @return ProdutoModel - produto salvo
	 */
	public ProdutoModel save(ProdutoModel produto) {
		return produtoRepository.save(produto);
    }

	/**
	 * Método para atualizar um produto existente
	 * 
	 * @param produto - produto a ser atualizado
	 * @return ProdutoModel - produto atualizado
	 */
	public ProdutoModel update(Integer id, ProdutoModel produto) {
		produto.setId(id);
		
        return produtoRepository.update(produto);
	}
	
	/**
	 * Método para deletar um produto
	 * 
	 * @param id - id do produto
	 * @return
	 */
	public void delete(Integer id) {
		produtoRepository.deleteById(id);

	}
}