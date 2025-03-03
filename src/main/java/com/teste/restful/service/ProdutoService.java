package com.teste.restful.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.restful.model.Produto;
import com.teste.restful.model.exception.ResourceNotFoundException;
import com.teste.restful.repository.ProdutoRepositoryOLD;
import com.teste.restful.shared.ProdutoDTO;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositoryOLD produtoRepository;
	
	/**
	 * Método para retornar todos os produtos
	 * 
	 * @param
	 * @return List<ProdutoModel> - lista de produtos
	 */
	public List<ProdutoDTO> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos
				.stream()
				.map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
				.collect(Collectors.toList());
    }
	
	
	/**
	 * Método para retornar um produto pelo id
	 * 
	 * @param id - id do produto
	 * @return ProdutoModel - produto
	 */
	public Optional<ProdutoDTO> findById(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if(produto.isEmpty()) {
			throw new ResourceNotFoundException("Produto não encontrado");
		}
		ProdutoDTO produtoDTO = new ModelMapper().map(produto.get(), ProdutoDTO.class);
		return Optional.of(produtoDTO);
	}
	
	
	/**
	 * Método para salvar um produto
	 * 
	 * @param produto - produto a ser salvo
	 * @return ProdutoModel - produto salvo
	 */
	public ProdutoDTO save(ProdutoDTO produtoDto) {
		produtoDto.setId(null);
		
		ModelMapper modelMapper = new ModelMapper();
		Produto produto = modelMapper.map(produtoDto, Produto.class);
		produto = produtoRepository.save(produto);
		produtoDto.setId(produto.getId());
		return produtoDto;
		
    }

	/**
	 * Método para atualizar um produto existente
	 * 
	 * @param produto - produto a ser atualizado
	 * @return ProdutoModel - produto atualizado
	 */
	public ProdutoDTO update(Integer id, ProdutoDTO produtoDto) {
		produtoDto.setId(id);
		ModelMapper modelMapper = new ModelMapper();
		Produto produtoToUpdate = modelMapper.map(produtoDto, Produto.class);
		produtoRepository.update(produtoToUpdate);
		return produtoDto;
	}
	
	/**
	 * Método para deletar um produto
	 * 
	 * @param id - id do produto
	 * @return
	 */
	public void delete(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.isEmpty()) {
			throw new ResourceNotFoundException("Produto "+id+" não encontrado");
		}
		
		produtoRepository.deleteById(id);
	}
}