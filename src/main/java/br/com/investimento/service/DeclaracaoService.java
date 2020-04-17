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
	
	public DeclaracaoModel retornaDeclaracaoSalva(DeclaracaoModel declaracao) {
		if (!validaId(declaracao.getId()))
			throw new BadRequest("ID invalido");
		 DeclaracaoModel declaracaoSalva = repository.findById(declaracao.getId());
		 return declaracaoSalva;
	}

	public boolean validaId(String id) {
				
		if(repository.existsById(id) == false) 
			return false;
			
		else return true;
	}
	
	public void validaPerfil(DeclaracaoModel declaracao) {
		DeclaracaoModel declaracaoSalva = retornaDeclaracaoSalva(declaracao);
		if(declaracao.getPerfil() != declaracaoSalva.getPerfil()) {
			declaracao.setPerfil(declaracaoSalva.getPerfil());
		}
	}
	
	public void validaAssinatura(DeclaracaoModel declaracao) {
		DeclaracaoModel declaracaoSalva = retornaDeclaracaoSalva(declaracao);
		if(declaracaoSalva.isAssinado() == true && declaracao.isAssinado() == false ) {
			throw new BadRequest("Nao e possivel mudar o estado da assinatura");
		}
	}

	public DeclaracaoModel assinaDeclaracao(DeclaracaoModel declaracaoRequest) {
		
		validaPerfil(declaracaoRequest);
		
		validaAssinatura(declaracaoRequest);
		
		declaracaoRequest.setAssinado(true);
		
		return this.save(declaracaoRequest);
	}

}
