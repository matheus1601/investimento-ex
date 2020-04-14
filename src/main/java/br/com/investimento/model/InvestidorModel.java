package br.com.investimento.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.investimento.enums.PerfilInvestidor;
import lombok.Data;

//@Entity = O nome da tabela da entidade será o mesmo da classe com a anotação
//@SequenceGenerator = Define um gerador de chave primária baseado em sequence de banco de dados
//AllocationSize = valor de incremento na sequence
@Entity(name="investidor")
@SequenceGenerator(name="id_investidor", sequenceName = "sq_investidor", allocationSize = 1)
public class InvestidorModel {

	//@GeneratedValue = Especifica a estratégia de geração de valores automáticos para os atributos
	@Id
	@GeneratedValue(generator = "id_investidor", strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private PerfilInvestidor perfil;
	
	
	//CascadeType = Indica quando uma alteração na entidade pai será propagara para as entidades filhas
	//CascadeType.PERSIST = somente operação de persist será refletida
	//@JoinColumn = adiciona uma coluna na tabela
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private EnderecoModel endereco;
	
	//mappedBy = indica o nome do atributo que mapeia aassociação do que mapeia a
	//associação do lado dono da chave estrangeira 
	@OneToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE})
	private List <DeclaracaoModel> declaracoes = new ArrayList<>();
	
	@OneToMany(cascade = {CascadeType.MERGE})
	private List<InvestimentoForaDaPlataformaModel> investimentosForaDaPlataforma = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PerfilInvestidor getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilInvestidor perfil) {
		this.perfil = perfil;
	}

	public EnderecoModel getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}

	public List<DeclaracaoModel> getDeclaracoes() {
		return declaracoes;
	}

	public void setDeclaracoes(List<DeclaracaoModel> declaracoes) {
		this.declaracoes = declaracoes;
	}

	public List<InvestimentoForaDaPlataformaModel> getInvestimentosForaDaPlataforma() {
		return investimentosForaDaPlataforma;
	}

	public void setInvestimentosForaDaPlataforma(List<InvestimentoForaDaPlataformaModel> investimentosForaDaPlataforma) {
		this.investimentosForaDaPlataforma = investimentosForaDaPlataforma;
	}

	
	
}
