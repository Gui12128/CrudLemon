package crudlemon.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import crudlemon.modelo.Carro;
import crudlemon.modelo.Topico;
import crudlemon.repository.CarroRepository;

public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;
	@NotNull @NotEmpty 
	private String marcaCarro;
	@NotNull @NotEmpty 
	private String modeloCarro;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getmarcaCarro() {
		return marcaCarro;
	}

	public void setmarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}
	
	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public Topico converter(CarroRepository carroRepository) {
		Carro carro = carroRepository.findByMarca(marcaCarro);
		
		if (carro == null) {
			throw new NullPointerException("Marca não existe");
		}
		
		return new Topico(titulo, mensagem, carro);
		
	}

}