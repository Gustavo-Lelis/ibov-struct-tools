package org.example.b3stocks.tad.fila;

public class FilaCheiaException extends Exception {
	
	private static final long serialVersionUID = 2205604804082710180L;

	public FilaCheiaException(String filaCheia) {
		super("fila cheia");
	}

}
