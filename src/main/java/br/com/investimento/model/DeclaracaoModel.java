package br.com.investimento.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

import br.com.investimento.enums.PerfilInvestidor;
import lombok.Data;

@Data
@Entity(name = "declaracao")
public class DeclaracaoModel {

	@Id
	private String id = UUID.randomUUID().toString();
	
	private String ip;
	
	private String userAgent;
	
	@Expose(deserialize = true)
	private boolean assinado;

	private LocalDateTime data;
	
	@Enumerated(EnumType.STRING)
	@Expose(deserialize = true)
	private PerfilInvestidor perfil = PerfilInvestidor.ATE_10K;
	
	public void atualizaPerfil(InvestidorModel investidor) {
		this.perfil = perfil.define(investidor.somaInvestimentosForaDaPlataforma());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeclaracaoModel other = (DeclaracaoModel) obj;
		if (perfil != other.perfil)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		return result;
	}
	
	public void assina() {
		this.assinado = true;
	}
	
}