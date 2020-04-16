package br.com.investimento.exception;

public class BadRequest extends RuntimeException{

	private static final long serialVersionUID = -864512419207959227L;

	public BadRequest(String msg) {
		super(msg);
	}
	
}
