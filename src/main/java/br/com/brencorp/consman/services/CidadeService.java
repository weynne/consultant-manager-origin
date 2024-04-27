package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Cidade;
import br.com.brencorp.consman.repositories.CidadeRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

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

	public Cidade insert(Cidade obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Cidade update(Long id, Cidade obj) {
		try {
			Cidade entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Cidade entity, Cidade obj) {
		entity.setNome(obj.getNome());
		entity.setEstado(obj.getEstado());
	}
}
