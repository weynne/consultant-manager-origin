package br.com.brencorp.consman.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.brencorp.consman.entities.Cidade;
import br.com.brencorp.consman.entities.Estado;
import br.com.brencorp.consman.repositories.CidadeRepository;
import br.com.brencorp.consman.repositories.EstadoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {

		Estado e1 = new Estado(null, "PE");
		Estado e2 = new Estado(null, "PB");

		Cidade c1 = new Cidade(null, "João Pessoa", e2);
		Cidade c2 = new Cidade(null, "Recife", e1);
		Cidade c3 = new Cidade(null, "Campina Grande", e2);
		Cidade c4 = new Cidade(null, "Olinda", e1);

		estadoRepository.saveAll(Arrays.asList(e1, e2));

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

	}

}
