package com.gamaacademy.apitest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamaacademy.apitest.model.Movimentacao;
import com.gamaacademy.apitest.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
@CrossOrigin("*")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> getById(@PathVariable Integer id) {
		Movimentacao obj = service.findById(id);
		return ResponseEntity.status(200).body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Movimentacao>> getAll() {
		List<Movimentacao> list = service.findAll();
		return ResponseEntity.status(200).body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Movimentacao objMovimentacao) {
		service.create(objMovimentacao);
		return ResponseEntity.status(201).body(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Movimentacao objMovimentacao) {
		service.update(id, objMovimentacao);
		return ResponseEntity.status(202).body(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
