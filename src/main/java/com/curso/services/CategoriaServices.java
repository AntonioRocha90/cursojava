package com.curso.services;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository repCat;
		 
	public List<Categoria> listarTodos() {
		return repCat.findAll();
	}
	
	public Optional<Categoria> listarUm(Integer identidade) {
		Optional<Categoria> obj = repCat.findById(identidade);
		return obj; 		
	}	
}