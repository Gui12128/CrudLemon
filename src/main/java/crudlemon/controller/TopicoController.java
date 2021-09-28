package crudlemon.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import crudlemon.controller.dto.DetalhesDoTopicoDTO;
import crudlemon.controller.dto.TopicoDTO;
import crudlemon.controller.form.AtualizacaoTopicoForm;
import crudlemon.controller.form.TopicoForm;
import crudlemon.modelo.Topico;
import crudlemon.repository.CarroRepository;
import crudlemon.repository.TopicoRepository;
import crudlemon.repository.UsuarioRepository;


@RestController
@RequestMapping("/topicos")
@CrossOrigin(origins = "http://localhost:4200")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@GetMapping																																																																																	
	@Cacheable(value = "listaDeTopicos")
	public List<TopicoDTO> lista(@RequestParam (required = false) String marcaCarro) {
		
		if (marcaCarro == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDTO.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCarro_Marca(marcaCarro);
			return TopicoDTO.converter(topicos);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(carroRepository, usuarioRepository);
		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); 
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id) {
		Optional<Topico> topico = topicoRepository.findById(id);
		
		if (topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDTO(topico.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizacaoTopicoForm form){
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
			Topico topico = form.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDTO(topico));
		}
		return ResponseEntity.notFound().build();

		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDTO> remover(@PathVariable Long id){
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}