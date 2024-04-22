package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Consultor;
import br.com.brencorp.consman.repositories.ConsultorRepository;

@Service
public class ConsultorService {

	@Autowired
	private ConsultorRepository repository;

	public List<Consultor> findAll() {
		return repository.findAll();
	}

	public Consultor findById(Long id) {
		Optional<Consultor> obj = repository.findById(id);
		return obj.get();
	}
}
