package br.com.investimento.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class InvestimentoForaDaPlataformaModel {

	@Id
	private String id = UUID.randomUUID().toString();
	
	private BigDecimal valor;
	
	private LocalDate data;

}
