package br.com.brencorp.consman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brencorp.consman.entities.Consultor;

public interface ConsultorRepository extends JpaRepository<Consultor, Long> {

}
