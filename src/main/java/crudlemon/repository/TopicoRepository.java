package crudlemon.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import crudlemon.modelo.Topico;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

	Page<Topico> findByCarro_Marca(String marcaCarro, Pageable paginacao);
	Page<Topico> findByCarro_Modelo(String modeloCarro, Pageable paginacao);

}