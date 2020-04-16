package br.com.investimento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.investimento.model.InvestidorModel;
import br.com.investimento.repository.InvestidorRepository;

@Service
@Transactional
public class InvestidorService {

	@Autowired
	private InvestidorRepository repository;
	
	public InvestidorModel busca(final String email) {
		return repository.findByEmail(email);
	}

	public InvestidorModel save(InvestidorModel model) {
		return repository.save(model);
	}
}
