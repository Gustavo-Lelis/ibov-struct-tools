package org.example.b3stocks.tad.fila;

import java.io.Serial;

public class FilaVaziaException extends Exception {
	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -2035554480259121771L;

	public FilaVaziaException() {
		super("fila vazia!");
	}
	
	public FilaVaziaException(String message) {
		super(message);
	}

}
