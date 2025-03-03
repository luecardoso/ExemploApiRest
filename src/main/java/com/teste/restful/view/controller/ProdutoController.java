package com.teste.restful.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.restful.service.ProdutoService;
import com.teste.restful.shared.ProdutoDTO;
import com.teste.restful.view.model.ProdutoRequest;
import com.teste.restful.view.model.ProdutoResponse;

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
	public ResponseEntity<List<ProdutoResponse>> findAll() {
		List<ProdutoDTO> produtoDto = produtoService.findAll();
		ModelMapper modelMapper = new ModelMapper();
		List<ProdutoResponse> resposta = produtoDto.stream()
				.map(produto -> modelMapper.map(produto, ProdutoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProdutoResponse>> findById(@PathVariable Integer id) {
		Optional<ProdutoDTO> produtoDto = produtoService.findById(id);
		ProdutoResponse resposta = new ModelMapper().map(produtoDto.get(), ProdutoResponse.class);
		return new ResponseEntity<>(Optional.of(resposta), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProdutoResponse> save(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoDTO produtoDto = new ModelMapper().map(produtoRequest, ProdutoDTO.class);
        produtoDto = produtoService.save(produtoDto);
        return new ResponseEntity<>(new ModelMapper().map(produtoDto, ProdutoResponse.class), HttpStatus.CREATED);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponse> update(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest) {
		ModelMapper modelMapper = new ModelMapper();
		ProdutoDTO produtoDto = modelMapper.map(produtoRequest, ProdutoDTO.class);
		
		produtoDto = produtoService.update(id, produtoDto);
		return new ResponseEntity<>(modelMapper.map(produtoDto, ProdutoResponse.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
