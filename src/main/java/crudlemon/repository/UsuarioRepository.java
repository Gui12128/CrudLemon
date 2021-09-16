package crudlemon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import crudlemon.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
}
