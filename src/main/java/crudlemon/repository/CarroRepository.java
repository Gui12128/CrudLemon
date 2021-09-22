package crudlemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crudlemon.modelo.Carro;


public interface CarroRepository extends JpaRepository<Carro, Long> {

	Carro findByMarca(String marcaCarro);

}