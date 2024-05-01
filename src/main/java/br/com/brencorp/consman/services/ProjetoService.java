package br.com.brencorp.consman.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brencorp.consman.dto.ProjetoDTO;
import br.com.brencorp.consman.entities.Projeto;
import br.com.brencorp.consman.repositories.ProjetoRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	@Transactional(readOnly = true)
	public List<ProjetoDTO> findAll() {
		List<Projeto> projetos = repository.findAll();
		return projetos.stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProjetoDTO findById(Long id) {
		Projeto projeto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new ProjetoDTO(projeto);
	}

	@Transactional
	public ProjetoDTO insert(ProjetoDTO projetoDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Projeto projeto = modelMapper.map(projetoDTO, Projeto.class);
		return new ProjetoDTO(repository.save(projeto));
	}

	@Transactional
	public ProjetoDTO update(Long id, ProjetoDTO projetoDTO) {
		try {
			Projeto projeto = repository.getReferenceById(id);
			updateProjeto(projeto, projetoDTO);
			return new ProjetoDTO(repository.save(projeto));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateProjeto(Projeto projeto, ProjetoDTO projetoDTO) {
		projeto.setDescricaoProjeto(projetoDTO.getDescricao());
	}

	@Transactional
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
}
