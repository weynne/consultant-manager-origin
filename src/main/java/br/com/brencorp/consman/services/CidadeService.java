package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Cidade;
import br.com.brencorp.consman.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public List<Cidade> findAll() {
		return repository.findAll();
	}

	public Cidade findById(Long id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.get();
	}
}
