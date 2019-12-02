package br.com.cartorio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cartorio.entities.Cartorio;
import br.com.cartorio.repositories.CartorioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private CartorioRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cartorio c1 = new Cartorio(null, "teste1");
		Cartorio c2 = new Cartorio(null, "teste2");
		Cartorio c3 = new Cartorio(null, "teste3");
		Cartorio c4 = new Cartorio(null, "teste4");
		
		repository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		
	}
}
