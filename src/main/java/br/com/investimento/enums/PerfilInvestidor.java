package br.com.investimento.enums;

import java.math.BigDecimal;

public enum PerfilInvestidor {
	
	ATE(10000) {
		@Override
		public PerfilInvestidor defini(BigDecimal somaDosValores) {
			return somaDosValores.intValue() <= this.valor() ? this : MENOS_DE.defini(somaDosValores);
		}
	},
	MENOS_DE(100000) {
		@Override
		public PerfilInvestidor defini(BigDecimal somaDosValores) {
			return somaDosValores.intValue() <= this.valor() ? this : ACIMA_DE.defini(somaDosValores);
		}
	},
	ACIMA_DE(100000) {
		@Override
		public PerfilInvestidor defini(BigDecimal somaDosValores) {
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
	
	public abstract PerfilInvestidor defini(final BigDecimal somaDosValores);
	
}
