package br.com.investimento.model;

import java.math.BigDecimal;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class InvestimentoForaDaPlataformaModel {

	@Id
	private int id;
	
	private BigDecimal valor;
	
	private LocalDate data;
	
}
