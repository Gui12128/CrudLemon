package crudlemon.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import crudlemon.modelo.Topico;

public class TopicoDTO {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String marcaCarro;
	private String modeloCarro;
	private String emailUsuario;
	
	public TopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.marcaCarro = topico.getCarro().getMarca();
		this.modeloCarro = topico.getCarro().getmodelo();
		this.emailUsuario = topico.getUsuario().getEmail();
		
	}
	

	public Long getId() {
		return id;
	}
	
	public String getMarcaCarro() {
		return marcaCarro;
	}
	

	public String getModeloCarro() {
		return modeloCarro;
	}


	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	
	public String getUsuarioEmail() {
		return emailUsuario;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<TopicoDTO> converter(List<Topico> topicos) {
		
		var listaDeTopicos = new ArrayList<TopicoDTO>();
		
		topicos.forEach(topico -> {
			listaDeTopicos.add(new TopicoDTO(topico));
		});
		
		return listaDeTopicos;
	}



	
}
