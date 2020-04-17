package br.com.investimento.enums;

import java.math.BigDecimal;

public enum PerfilInvestidor {
	
	ATE_10K(10000) {
		@Override
		public PerfilInvestidor define(BigDecimal somaDosValores) {
			return somaDosValores.intValue() <= this.valor() ? this : MENOS_DE_100K.define(somaDosValores);
		}
	},
	MENOS_DE_100K(100000) {
		@Override
		public PerfilInvestidor define(BigDecimal somaDosValores) {
			return somaDosValores.intValue() <= this.valor() ? this : ACIMA_DE_100K.define(somaDosValores);
		}
	},
	ACIMA_DE_100K(100000) {
		@Override
		public PerfilInvestidor define(BigDecimal somaDosValores) {
			return somaDosValores.intValue() > this.valor() ? this : null;
		}
	};
	
	private int valor;
	
	PerfilInvestidor(int i) {
		this.valor = i;
	}
	
	public int valor() {
		return this.valor;
	}
	
	public abstract PerfilInvestidor define(final BigDecimal somaDosValores);
	
}
