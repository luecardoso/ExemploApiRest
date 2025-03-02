package com.teste.restful.model.error;

public class ErrorMessage {

	private String titulo;
	private Integer status;
	private String detalhe;
	
	public ErrorMessage(String titulo, Integer status, String detalhe) {
		this.titulo = titulo;
		this.status = status;
		this.detalhe = detalhe;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
}
