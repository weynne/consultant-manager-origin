package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Estado;
import br.com.brencorp.consman.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> findAll() {
		return repository.findAll();
	}

	public Estado findById(Long id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.get();
	}
}
