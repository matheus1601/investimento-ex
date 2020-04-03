package br.com.investimento.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "endereco")
@SequenceGenerator(name="id_endereco", sequenceName = "sq_investidor", allocationSize = 1)
public class EnderecoModel {

	@Id
	@GeneratedValue(generator = "id_endereco", strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String cep;
	
	private String rua;
	
	private String complemento;
	
	private String numero;
	
	private String bairro;
	
	
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.PERSIST)
	private InvestidorModel investidor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InvestidorModel getInvestidor() {
		return investidor;
	}

	public void setInvestidor(InvestidorModel investidor) {
		this.investidor = investidor;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
