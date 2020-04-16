package br.com.investimento.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "declaracao")
public class DeclaracaoModel {

	@Id
	private String id = UUID.randomUUID().toString();
	
	private String ip;
	
	private String userAgent;
	
	private boolean assinado;

	private LocalDateTime data;
	
	
}
