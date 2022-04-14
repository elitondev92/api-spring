package com.gamaacademy.apitest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamaacademy.apitest.model.Movimentacao;
import com.gamaacademy.apitest.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repository;
	
	public Movimentacao findById(Integer id) {
		Optional<Movimentacao> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Movimentacao> findAll() {
		return repository.findAll();
	}
	
	public void update(Integer id, Movimentacao obj) {
		Movimentacao newObj = findById(id);
		newObj.setCartao(obj.getCartao());
		newObj.setData(obj.getData());
		newObj.setValor(obj.getValor());
		repository.save(newObj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public void create(Movimentacao obj) {
		repository.save(obj);
	}
}
