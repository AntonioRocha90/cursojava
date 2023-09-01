package com.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.domain.Categoria;
import com.curso.domain.Produto;
import com.curso.repositories.CategoriaRepository;
import com.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursojavaApplication implements CommandLineRunner {
	@Autowired
	CategoriaRepository catRep;
	
	@Autowired	
	ProdutoRepository proRep;
	
	public static void main(String[] args) {
		SpringApplication.run(CursojavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Escritorio");
		Categoria cat2 = new Categoria(null, "Casa");
		
		Produto pro1 = new Produto(null, "Pimenta",1.50);
		Produto pro2 = new Produto(null, "Celular",1.600);
		Produto pro3 = new Produto(null, "Veneno",15.0);

		pro1.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(pro1));

		pro2.getCategorias().addAll(Arrays.asList(cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat2));
		cat2.getProdutos().addAll(Arrays.asList(pro2,pro3));

		catRep.saveAll(Arrays.asList(cat1,cat2));
		proRep.saveAll(Arrays.asList(pro1,pro2,pro3));
	}
}