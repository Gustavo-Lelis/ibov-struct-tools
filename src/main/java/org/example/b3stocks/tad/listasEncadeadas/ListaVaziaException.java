package org.example.b3stocks.tad.listasEncadeadas;

import java.io.Serial;

public class ListaVaziaException extends Exception {
	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -2035554480259121771L;

	public ListaVaziaException() {
		super("lista vazia!");
	}
	
	public ListaVaziaException(String message) {
		super(message);
	}

}
