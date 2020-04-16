package br.com.investimento.service;

import org.springframework.transaction.annotation.Transactional;

import br.com.investimento.enums.PerfilInvestidor;
import br.com.investimento.exception.BadRequest;
import br.com.investimento.model.DeclaracaoModel;
import br.com.investimento.model.InvestidorModel;
import br.com.investimento.repository.DeclaracaoRepository;
import javassist.tools.web.BadHttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeclaracaoService {
	
	@Autowired
	private InvestidorService investidorService;
	
	@Autowired
	private DeclaracaoRepository repository;
	
	public DeclaracaoModel save(DeclaracaoModel model) {
		return repository.save(model);
	}
	
	public DeclaracaoModel assinaDeclaracao(DeclaracaoModel declaracaoRequest) {
		
		DeclaracaoModel declaracaoSalva = repository.findById(declaracaoRequest.getId());
		//Esse if nao entra nunca, pois a linha 31 da null pointer
		if(!(declaracaoRequest.getId().equals(declaracaoSalva.getId()))) {
			throw new BadRequest("ID invalido");
		}
		else if(declaracaoRequest.getPerfil() != declaracaoSalva.getPerfil()) {
			throw new BadRequest("Perfil invalido");
		}
		else if(declaracaoSalva.isAssinado() == true && declaracaoRequest.isAssinado() == false ) {
			throw new BadRequest("Nao e possivel mudar o estado da assinatura");
		}

		else if (declaracaoRequest.isAssinado() == true) {
			declaracaoRequest.setAssinado(true);
		}
		return this.save(declaracaoRequest);
	}
}
