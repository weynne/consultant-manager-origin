package br.com.brencorp.consman.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.brencorp.consman.entities.Cat;
import br.com.brencorp.consman.entities.Cidade;
import br.com.brencorp.consman.entities.Estado;
import br.com.brencorp.consman.entities.Projeto;
import br.com.brencorp.consman.repositories.CatRepository;
import br.com.brencorp.consman.repositories.CidadeRepository;
import br.com.brencorp.consman.repositories.EstadoRepository;
import br.com.brencorp.consman.repositories.ProjetoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private CatRepository catRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Cat cat1 = new Cat(null, "Descrição Cat1");
		Cat cat2 = new Cat(null, "Descrição Cat2");
		Cat cat3 = new Cat(null, "Descrição Cat3");
		Cat cat4 = new Cat(null, "Descrição Cat4");
		
		catRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		Projeto p1 = new Projeto(null, "Descrição projeto 1");
		Projeto p2 = new Projeto(null, "Descrição projeto 2");
		Projeto p3 = new Projeto(null, "Descrição projeto 3");
		Projeto p4 = new Projeto(null, "Descrição projeto 4");
		
		projetoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		Estado e1 = new Estado(null, "PE");
		Estado e2 = new Estado(null, "PB");

		Cidade c1 = new Cidade(null, "João Pessoa", e2);
		Cidade c2 = new Cidade(null, "Recife", e1);
		Cidade c3 = new Cidade(null, "Campina Grande", e2);
		Cidade c4 = new Cidade(null, "Caruaru", e1);

		estadoRepository.saveAll(Arrays.asList(e1, e2));

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

	}

}
