package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Categoria;
import com.curso.services.CategoriaServices;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaServices catService;
	
	@GetMapping("/")
	public ResponseEntity<?> Listartodos() {
		List<Categoria> obj = catService.listarTodos();
		return ResponseEntity.ok().body(obj);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ListarUm(@PathVariable Integer id) {
		Optional<Categoria> obj = catService.listarUm(id);
		return ResponseEntity.ok().body(obj);
	}
}
