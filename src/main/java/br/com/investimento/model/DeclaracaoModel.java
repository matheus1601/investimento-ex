package br.com.investimento.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "declaracao")
@SequenceGenerator(name="id_declaracao", sequenceName = "sq_investidor", allocationSize = 1)
public class DeclaracaoModel {

	@Id
	@GeneratedValue(generator = "id_declaracao", strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String ip;
	
	private String userAgent;
	
	private boolean assinado;

	//@Temporal = Especifica o tipo de dado a ser armazenado em propriedades do tipo Date e Calendar
	//TIMESTAMP = data e hora
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name="id_investidor")
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public boolean isAssinado() {
		return assinado;
	}

	public void setAssinado(boolean assinado) {
		this.assinado = assinado;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
