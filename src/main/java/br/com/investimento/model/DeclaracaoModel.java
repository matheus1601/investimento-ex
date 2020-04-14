package br.com.investimento.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity(name = "declaracao")
@SequenceGenerator(name="id_declaracao", sequenceName = "sq_investidor", allocationSize = 1)
public class DeclaracaoModel {

	@Id
	@GeneratedValue(generator = "id_declaracao", strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String ip;
	
	private String userAgent;
	
	private boolean assinado;

	private LocalDateTime data;
	
	
}
