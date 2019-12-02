package br.com.cartorio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartorio.entities.Cartorio;
import br.com.cartorio.repositories.CartorioRepository;

@Service
public class CartorioService {

	@Autowired
	private CartorioRepository repository;

	public List<Cartorio> listarCartorios() {
		return repository.findAll();
	}

	public Cartorio visualizarCartorio(Long id) {
		Optional<Cartorio> obj = repository.findById(id);
		return obj.get();
	}

	public Cartorio inserirCartorio(Cartorio obj) {
		return repository.save(obj);
	}

	public void excluirCartorio(Long id) {
		repository.deleteById(id);
	}
	
	public Cartorio editarCartorio(Long id, Cartorio obj) {
		Cartorio entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Cartorio entity, Cartorio obj) {
		entity.setNome(obj.getNome());
	}

}
