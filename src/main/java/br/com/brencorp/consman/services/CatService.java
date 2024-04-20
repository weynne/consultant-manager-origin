package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Cat;
import br.com.brencorp.consman.repositories.CatRepository;

@Service
public class CatService {

	@Autowired
	private CatRepository repository;

	public List<Cat> findAll() {
		return repository.findAll();
	}

	public Cat findById(Long id) {
		Optional<Cat> obj = repository.findById(id);
		return obj.get();
	}
}
