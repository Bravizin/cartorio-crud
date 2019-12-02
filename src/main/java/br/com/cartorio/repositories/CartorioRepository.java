package br.com.cartorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartorio.entities.Cartorio;

public interface CartorioRepository extends JpaRepository<Cartorio, Long> {
	
}
