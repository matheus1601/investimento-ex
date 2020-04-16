package br.com.investimento.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.investimento.enums.PerfilInvestidor;
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
	
	public InvestidorModel adicionaNovoInvestimentoExterno(final InvestimentoForaDaPlataformaModel investimento, String email){
		validaValorInvestimentoExterno(investimento);

		InvestidorModel investidor = investidorService.busca(email);

		investidor.novoInvestimentoExterno(investimento);

		DeclaracaoModel declaracao = new DeclaracaoModel();

		declaracao.atualizaPerfil(investidor);

		for (int i = 0; i < investidor.getDeclaracoes().size(); i++) {
			if (declaracao.equals(investidor.getDeclaracoes().get(i)))
				return this.investidorService.save(investidor);
		}
		investidor.novaDeclaracao(declaracao);
		return this.investidorService.save(investidor);

	}
	
	private void validaValorInvestimentoExterno(final InvestimentoForaDaPlataformaModel investimento) {
		if(!isValido(investimento.getValor()))
			throw new BadRequest("Valor invalido");
	}
}
