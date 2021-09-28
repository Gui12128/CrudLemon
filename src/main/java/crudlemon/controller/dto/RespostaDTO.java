package crudlemon.controller.dto;

import java.time.LocalDateTime;

import crudlemon.modelo.Resposta;

public class RespostaDTO {

	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeUsuario;
	private String marcaCarro;
	private String modeloCarro;
	
	public RespostaDTO(Resposta resposta) {
		this.id = resposta.getId();
		this.dataCriacao = resposta.getDataCriacao();
		this.mensagem = resposta.getMensagem();
		this.nomeUsuario = resposta.getUsuario().getNome();
		this.marcaCarro = resposta.getCarro().getMarca();
		this.modeloCarro = resposta.getCarro().getmodelo();
	}


	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeUsuario;
	}


	public String getMarcaCarro() {
		return marcaCarro;
	}


	public String getModeloCarro() {
		return modeloCarro;
	}
	
}
