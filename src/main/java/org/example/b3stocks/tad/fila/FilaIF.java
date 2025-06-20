package org.example.b3stocks.tad.fila;

public interface FilaIF<E> {
	
	public void enfileirar(E item) throws FilaCheiaException;
	
	public E desenfileirar() throws FilaVaziaException;
	
	public E verificarCauda();
	
	public E verificarCabeca();
	
	public boolean isEmpty();
	
	public boolean isFull();

	public int capacidade();

	public int tamanho();
}
