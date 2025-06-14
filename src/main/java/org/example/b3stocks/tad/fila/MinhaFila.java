package org.example.b3stocks.tad.fila;

@SuppressWarnings("unchecked")
public class MinhaFila<T> implements FilaIF<T> {

	private int tamanho = 10;

	private int cauda = 0;
	private int cabeca = 0;
	private int quantidade = 0;

	private T[] meusDados;

	public MinhaFila(int tamanhoInicial) {
		this.tamanho = tamanhoInicial;
		this.meusDados = (T[]) new Object[tamanhoInicial];
	}

	public MinhaFila() {
		this.meusDados = (T[]) new Object[tamanho];
	}

	@Override
	public void enfileirar(T item) throws FilaCheiaException {
		if (isFull()) throw new FilaCheiaException("fila cheia");

		meusDados[cauda] = item;
		cauda = (cauda + 1) % tamanho;
		quantidade++;
	}

	@Override
	public T desenfileirar() throws FilaVaziaException {
		if (isEmpty()) throw new FilaVaziaException();

		T item = meusDados[cabeca];
		cabeca = (cabeca + 1) % tamanho;
		quantidade--;
		return item;
	}

	@Override
	public T verificarCauda() {
		if (isEmpty()) return null;

		int indiceAnterior = (cauda - 1 + tamanho) % tamanho;
		return meusDados[indiceAnterior];
	}

	@Override
	public T verificarCabeca() {
		if (isEmpty()) return null;
		return meusDados[cabeca];
	}

	@Override
	public boolean isEmpty() {
		return quantidade == 0;
	}

	@Override
	public boolean isFull() {
		return quantidade == tamanho;
	}

	@Override
	public int capacidade() {
		return tamanho;
	}

	@Override
	public int tamanho() {
		return quantidade;
	}
}
