package edu.sinqia.joaoortegabr.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import edu.sinqia.joaoortegabr.entities.Carro;
import edu.sinqia.joaoortegabr.entities.Categoria;
import edu.sinqia.joaoortegabr.entities.Cliente;
import edu.sinqia.joaoortegabr.entities.Locacao;
import edu.sinqia.joaoortegabr.entities.Loja;
import edu.sinqia.joaoortegabr.entities.Montadora;
import edu.sinqia.joaoortegabr.enums.Cor;
import edu.sinqia.joaoortegabr.repositories.CarroRepository;
import edu.sinqia.joaoortegabr.repositories.CategoriaRepository;
import edu.sinqia.joaoortegabr.repositories.ClienteRepository;
import edu.sinqia.joaoortegabr.repositories.LocacaoRepository;
import edu.sinqia.joaoortegabr.repositories.LojaRepository;
import edu.sinqia.joaoortegabr.repositories.MontadoraRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private MontadoraRepository montadoraRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Montadora m1 = new Montadora(null, "Ford");
		Montadora m2 = new Montadora(null, "Volkswagen");
		Montadora m3 = new Montadora(null, "Renault");
		montadoraRepository.saveAll(Arrays.asList(m1, m2, m3));
		
		Categoria k1 = new Categoria(null, "Hatch");
		Categoria k2 = new Categoria(null, "Sedan");
		Categoria k3 = new Categoria(null, "SUV");
		categoriaRepository.saveAll(Arrays.asList(k1, k2, k3));

		Cliente c1 = new Cliente(null, "José Andrade", "1178987-9308", "jose@email.com");
		Cliente c2 = new Cliente(null, "Maria Rodrigues", "1198475-1239", "maria@email.com");
		Cliente c3 = new Cliente(null, "Manoel Silva", "1198893-0193", "manoel@email.com");
		Cliente c4 = new Cliente(null, "Thomas Tigando", "1198980-1100", "thomas@email.com");
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Loja l1 = new Loja(null, "Pompeia");
		Loja l2 = new Loja(null, "Morumbi");
		Loja l3 = new Loja(null, "Centro");
		Loja l4 = new Loja(null, "Vila Mariana");
		Loja l5 = new Loja(null, "Tatuape");
		lojaRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
		Carro x1 = new Carro(null, "Ka", m1, k1, Cor.branco, l1);
		Carro x2 = new Carro(null, "Gol", m2, k1, Cor.preto, l2);
		Carro x3 = new Carro(null, "Clio", m3, k2, Cor.prata, l2);
		Carro x4 = new Carro(null, "Fiesta", m1, k2, Cor.prata, l3);
		Carro x5 = new Carro(null, "Nivus", m2, k3, Cor.branco, l4);
		Carro x6 = new Carro(null, "Ka", m1, k1, Cor.preto, l5);
		carroRepository.saveAll(Arrays.asList(x1, x2, x3, x4, x5, x6));
		
		Locacao y1 = new Locacao(null, LocalDate.parse("2022-10-10"), x1, c1, 52.0, l1, l2);
		Locacao y2 = new Locacao(null, LocalDate.parse("2022-10-15"), x4, c2, 30.8, l3, l4);
		Locacao y3 = new Locacao(null, LocalDate.parse("2022-10-10"), x2, c3, 89.2, l2, l5);
		Locacao y4 = new Locacao(null, LocalDate.parse("2023-07-15"), x1, c1, 114.0, l4, l5);
		Locacao y5 = new Locacao(null, LocalDate.parse("2022-10-16"), x6, c2, 90.3, l1, l2);
		Locacao y6 = new Locacao(null, LocalDate.parse("2022-12-11"), x1, c4, 87.7, l3, l4);
		Locacao y7 = new Locacao(null, LocalDate.parse("2022-10-08"), x5, c2, 34.0, l4, l3);
		Locacao y8 = new Locacao(null, LocalDate.parse("2022-11-05"), x6, c2, 27.5, l1, l4);
		Locacao y9 = new Locacao(null, LocalDate.parse("2023-10-20"), x3, c3, 140.4, l2, l2);
		Locacao y10 = new Locacao(null, LocalDate.parse("2023-12-17"), x2, c1, 31.5, l5, l4);
		locacaoRepository.saveAll(Arrays.asList(y1, y2, y3, y4, y5, y6, y7, y8, y9, y10));
		
	}
	
}
