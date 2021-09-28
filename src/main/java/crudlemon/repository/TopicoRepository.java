package crudlemon.repository;


import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import crudlemon.modelo.Topico;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCarro_Marca(String marcaCarro);
	List<Topico> findByUsuario_Email(String emailUsuario);

}