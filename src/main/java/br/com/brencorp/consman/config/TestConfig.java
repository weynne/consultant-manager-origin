package br.com.brencorp.consman.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.brencorp.consman.entities.Estado;
import br.com.brencorp.consman.repositories.EstadoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public void run(String... args) throws Exception {

		Estado e1 = new Estado(null, "PE");
		Estado e2 = new Estado(null, "PB");

		estadoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
