package br.com.investimento.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.investimento.enums.PerfilInvestidor;
import lombok.Data;

@Data
@Entity(name="investidor")
public class InvestidorModel {

	@Id
	private String id = UUID.randomUUID().toString();
	
	private String nome;
	
	private String email;
	
	private String cpf;

	@Enumerated(EnumType.STRING)
	private PerfilInvestidor perfil;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private EnderecoModel endereco;
	
	@OneToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List <DeclaracaoModel> declaracoes = new ArrayList<>();
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<InvestimentoForaDaPlataformaModel> investimentosForaDaPlataforma = new ArrayList<>();
	
	public void atualizaPerfil() {
		this.perfil = this.perfil.defini(somaInvestimentosForaDaPlataforma());
	}
	
	private BigDecimal somaInvestimentosForaDaPlataforma() {
		return new BigDecimal(this.investimentosForaDaPlataforma.stream()
												 				.mapToInt(i -> i.getValor().intValue())
												 				.sum());
	}
	
	public void novoInvestimentoExterno(final InvestimentoForaDaPlataformaModel investimento) {
		this.investimentosForaDaPlataforma.add(investimento);
	}
}
