package crudlemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crudlemon.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String emailUsuario);
}
