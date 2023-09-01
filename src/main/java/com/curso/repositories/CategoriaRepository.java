package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
}