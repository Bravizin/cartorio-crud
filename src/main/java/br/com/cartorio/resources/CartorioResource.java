package br.com.cartorio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartorio.entities.Cartorio;
import br.com.cartorio.services.CartorioService;

@RestController
@RequestMapping("/cartorios")
public class CartorioResource {
	
	@Autowired
	private CartorioService cartorioSevice;
	
	@GetMapping
	public ResponseEntity<List<Cartorio>> findAll(){
		List<Cartorio> cartorios = cartorioSevice.listarCartorios();
		return ResponseEntity.ok().body(cartorios);
	}
	
}
