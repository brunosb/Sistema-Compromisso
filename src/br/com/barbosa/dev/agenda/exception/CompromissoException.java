package br.com.barbosa.dev.agenda.exception;

import javax.servlet.ServletException;

public class CompromissoException extends ServletException{
	
	public CompromissoException(String msg) {
		super(msg);
	}
	
	public CompromissoException(){
		super();
	}

}
