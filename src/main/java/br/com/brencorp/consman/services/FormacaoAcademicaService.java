package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.FormacaoAcademica;
import br.com.brencorp.consman.repositories.FormacaoAcademicaRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FormacaoAcademicaService {

	@Autowired
	private FormacaoAcademicaRepository repository;

	public List<FormacaoAcademica> findAll() {
		return repository.findAll();
	}

	public FormacaoAcademica findById(Long id) {
		Optional<FormacaoAcademica> obj = repository.findById(id);
		return obj.get();
	}

	public FormacaoAcademica insert(FormacaoAcademica obj) {
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

	public FormacaoAcademica update(Long id, FormacaoAcademica obj) {
		try {
			FormacaoAcademica entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(FormacaoAcademica entity, FormacaoAcademica obj) {
		entity.setNome(obj.getNome());
		entity.setInstituicao(obj.getInstituicao());
		entity.setTipo(obj.getTipo());
		entity.setAnoConclusao(obj.getAnoConclusao());
	}
}
