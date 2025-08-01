package org.example.b3stocks.tad.pilha;

public interface PilhaIF<E> {
	
	public void empilhar(E item) throws PilhaCheiaException;
	
	public E desempilhar() throws PilhaVaziaException;
	
	public E topo();
	
	public PilhaIF<E> multitop(int k) throws PilhaVaziaException;
	
	public boolean isEmpty();

    public int capacidade();

	public int tamanho();
}
