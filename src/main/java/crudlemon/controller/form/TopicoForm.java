package crudlemon.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import crudlemon.modelo.Carro;
import crudlemon.modelo.Topico;
import crudlemon.modelo.Usuario;
import crudlemon.repository.CarroRepository;
import crudlemon.repository.UsuarioRepository;

public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;
	@NotNull @NotEmpty 
	private String marcaCarro;
	@NotNull
	private String modeloCarro;
	@NotNull
	private String emailUsuario;

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

	public String getUsuarioEmail() {
		return emailUsuario;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.emailUsuario = usuarioEmail;
	}

	public Topico converter(CarroRepository carroRepository, UsuarioRepository usuarioRepository) {
		Carro carro = carroRepository.findByMarca(marcaCarro);
		carro = carroRepository.findByModelo(modeloCarro);
		Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
			
		if (carro == null) {
			throw new NullPointerException("Marca ou modelo não existe");
		} else if (usuario == null) {
			throw new NullPointerException("Email não cadastrado");
		}
		
		return new Topico(titulo, mensagem, carro, usuario);
			
	}
}
	


