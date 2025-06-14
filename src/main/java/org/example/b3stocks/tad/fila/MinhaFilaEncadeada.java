package org.example.b3stocks.tad.fila;

import org.example.b3stocks.tad.listasEncadeadas.NodoListaEncadeada;

/**
 * Implementação de fila dinâmica baseada em lista encadeada simples.
 *
 * <p>Segue o comportamento FIFO (First-In, First-Out), onde elementos são inseridos
 * no final (cauda) e removidos do início (cabeça).</p>
 *
 * <p>Por ser baseada em nós encadeados, esta estrutura cresce dinamicamente conforme a necessidade,
 * não havendo limitação de tamanho (salvo pela memória).</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João
 *  Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.0</p>
 */
public class MinhaFilaEncadeada implements FilaIF<Integer> {

	private NodoListaEncadeada<Integer> cabeca;

	private NodoListaEncadeada<Integer> cauda;
	private int tamanho = 0;

	public MinhaFilaEncadeada() {
		cabeca = null;
		cauda = null;
	}


	/**
	 * Insere um novo item no final da fila.
	 *
	 * @param item o valor a ser enfileirado
	 */
	@Override
	public void enfileirar(Integer item) {
		NodoListaEncadeada<Integer> novoNodo = new NodoListaEncadeada<>(item);
		if (isEmpty()) {
			cabeca = novoNodo;
			cauda = novoNodo;
		} else {
			cauda.setProximo(novoNodo);
			cauda = novoNodo;
		}
	}


	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		Integer valor = cabeca.getChave();
		cabeca = cabeca.getProximo();
		if (cabeca == null) cauda = null; // fila ficou vazia
		return valor;
	}


	/**
	 * Retorna o valor armazenado na cabeça da fila, sem removê-lo.
	 *
	 * @return valor da cabeça, ou {@code null} se a fila estiver vazia
	 */
	@Override
	public Integer verificarCabeca() {
		if(cabeca != null){
			return cabeca.getChave();
		} else {
			return null;
		}
	}

	/**
	 * Retorna o valor armazenado na cauda da fila.
	 *
	 * @return valor da cauda, ou {@code null} se a fila estiver vazia
	 */
	@Override
	public Integer verificarCauda() {
		if(cauda != null){
			return cauda.getChave();
		} else {
			return null;
		}
	}

	/**
	 * Indica se a fila está vazia.
	 *
	 * @return {@code true} se a fila estiver vazia, {@code false} caso contrário
	 */
	@Override
	public boolean isEmpty() {
		return cabeca == null;
	}


	@Override
	public boolean isFull() {
		return false; // fila encadeada não tem limite fixo
	}


	@Override
	public int capacidade() {
		return Integer.MAX_VALUE; // ou -1 para indicar ilimitado
	}


	@Override
	public int tamanho() {
		int contador = 0;
		NodoListaEncadeada<Integer> atual = cabeca;
		while (atual != null) {
			contador++;
			atual = atual.getProximo();
		}
		return contador;
	}
}
