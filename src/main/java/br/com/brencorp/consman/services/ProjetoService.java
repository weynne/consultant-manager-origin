package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Projeto;
import br.com.brencorp.consman.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	public List<Projeto> findAll() {
		return repository.findAll();
	}

	public Projeto findById(Long id) {
		Optional<Projeto> obj = repository.findById(id);
		return obj.get();
	}
}
