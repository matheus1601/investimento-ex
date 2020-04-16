package br.com.investimento.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "endereco")
public class EnderecoModel {

	@Id
	private String id = UUID.randomUUID().toString();
	
	private String cep;
	
	private String rua;
	
	private String complemento;
	
	private String numero;
	
	private String bairro;
	
}
