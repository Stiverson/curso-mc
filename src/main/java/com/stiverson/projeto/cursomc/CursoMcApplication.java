package com.stiverson.projeto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stiverson.projeto.cursomc.domain.Categoria;
import com.stiverson.projeto.cursomc.domain.Cidade;
import com.stiverson.projeto.cursomc.domain.Estado;
import com.stiverson.projeto.cursomc.domain.Produto;
import com.stiverson.projeto.cursomc.repositories.CategoriaRepository;
import com.stiverson.projeto.cursomc.repositories.CidadeRepository;
import com.stiverson.projeto.cursomc.repositories.EstadoRepository;
import com.stiverson.projeto.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Games");
		
		Produto p1 = new Produto (null,"Notebook", 2500.00);
		Produto p2 = new Produto (null,"Impressora", 800.00);
		Produto p3 = new Produto (null,"God of war", 150.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Piracicaba",est2);
		Cidade c2 = new Cidade(null,"Uberlândia",est1);
		Cidade c3 = new Cidade(null,"São Paulo",est2);
		
		est1.getCidades().addAll(Arrays.asList(c2));
		est2.getCidades().addAll(Arrays.asList(c1,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}
