package com.teste.restful.view.model;

public class ProdutoRequest {

	private String nome;
	private Integer quantidade;
	private Double valor;
	private String descricao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor
				+ ", descricao=" + descricao + "]";
	}
}
