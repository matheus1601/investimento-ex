package br.com.investimento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.investimento.exception.BadRequest;
import br.com.investimento.model.DeclaracaoModel;
import br.com.investimento.repository.DeclaracaoRepository;

@Service
@Transactional
public class DeclaracaoService {

	@Autowired
	private DeclaracaoRepository repository;

	public DeclaracaoModel save(DeclaracaoModel model) {
		return repository.save(model);
	}
	
	public DeclaracaoModel retornaDeclaracaoSalva(String id) {
		if (!validaExistenciaDeclaracao(id))
			throw new BadRequest("ID invalido");
		 DeclaracaoModel declaracaoSalva = repository.findById(id);
		 return declaracaoSalva;
	}

	public boolean validaExistenciaDeclaracao(String id) {
		return repository.existsById(id);
	}
	

	public DeclaracaoModel assinaDeclaracao(DeclaracaoModel declaracao) {
		
		declaracao.assina();
		
		return this.save(declaracao);
	}

}
