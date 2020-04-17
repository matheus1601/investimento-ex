package br.com.investimento.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.investimento.exception.BadRequest;
import br.com.investimento.model.DeclaracaoModel;
import br.com.investimento.model.InvestidorModel;
import br.com.investimento.model.InvestimentoForaDaPlataformaModel;

@Service
@Transactional
public class InvestimentoService {

	@Autowired
	private InvestidorService investidorService;
	
	public boolean isValido(final BigDecimal valor) {
		return valor.compareTo(BigDecimal.ZERO) > 0;
	}
	
	public InvestidorModel atualizaInvestidor(InvestimentoForaDaPlataformaModel investimento, String email) {
		InvestidorModel investidor = investidorService.busca(email);
		adicionaNovoInvestimentoExterno(investimento, email, investidor);
		atualizaDeclaracoesDoPerfil(investidor);
		return investidor;
	}
	
	private void  adicionaNovoInvestimentoExterno(final InvestimentoForaDaPlataformaModel investimento, String email,
																				  		InvestidorModel investidor){
		validaValorInvestimentoExterno(investimento);
		investidor.novoInvestimentoExterno(investimento);
	}
	
	private InvestidorModel atualizaDeclaracoesDoPerfil(InvestidorModel investidor) {
		DeclaracaoModel declaracao = new DeclaracaoModel();
		declaracao.atualizaPerfil(investidor);
		if (validaNovaDeclaracao(investidor, declaracao)) 
		investidor.novaDeclaracao(declaracao);
		return this.investidorService.save(investidor);
		
	}
	
	private boolean validaNovaDeclaracao(InvestidorModel investidor, DeclaracaoModel declaracao) {
		for (int i = 0; i < investidor.getDeclaracoes().size(); i++) {
			if (declaracao.equals(investidor.getDeclaracoes().get(i)))
			return false;
		}
			return true;
	}
	
	
	private void validaValorInvestimentoExterno(final InvestimentoForaDaPlataformaModel investimento) {
		if(!isValido(investimento.getValor()))
			throw new BadRequest("Valor invalido");
	}
	
}
