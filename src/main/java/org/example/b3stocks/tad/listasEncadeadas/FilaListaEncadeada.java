package org.example.b3stocks.tad.listasEncadeadas;

import org.example.b3stocks.tad.fila.FilaCheiaException;
import org.example.b3stocks.tad.fila.FilaIF;
import org.example.b3stocks.tad.fila.FilaVaziaException;
/**
 * Implementação de fila baseada em lista encadeada.
 *
 * <p>Utiliza uma estrutura de lista própria para manter os elementos da fila,
 * garantindo inserções no final e remoções no início, conforme o modelo FIFO.</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João
 *   Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.0</p>
 */
public class FilaListaEncadeada implements  FilaIF<NodoListaEncadeada<Integer>> {

	private ListaEncadeadaImpl<Integer> fila;

	public FilaListaEncadeada() {
		this.fila = new ListaEncadeadaImpl<>();
	}
	/**
	 * Enfileira um novo elemento no final da lista.
	 *
	 * @param item o valor a ser adicionado
	 * @throws FilaCheiaException não aplicável neste caso, pois a lista é dinâmica
	 */
	@Override
	public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
		fila.insert(item.getChave()); // insere no fim
	}
	/**
	 * Remove e retorna o primeiro elemento da fila.
	 *
	 * @return o valor removido da cabeça
	 * @throws FilaVaziaException se a fila estiver vazia
	 */
	@Override
	public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
		if (fila.isEmpty()) {
			throw new FilaVaziaException();
		}
		NodoListaEncadeada<Integer> anterior = fila.getCabeca();
		NodoListaEncadeada<Integer> primeiro = anterior.getProximo();

		anterior.setProximo(primeiro.getProximo());
		return primeiro;
	}

	/**
	 * Retorna o último elemento enfileirado, sem removê-lo.
	 *
	 * @return o valor da cauda, ou {@code null} se a fila estiver vazia
	 */
	@Override
	public NodoListaEncadeada<Integer> verificarCauda() {
		NodoListaEncadeada<Integer> atual = fila.getCabeca().getProximo();
		if (atual.isNull()) return null;

		while (!atual.getProximo().isNull()) {
			atual = atual.getProximo();
		}
		return atual;
	}
	/**
	 * Retorna o primeiro elemento da fila, sem removê-lo.
	 *
	 * @return o valor da cabeça, ou {@code null} se a fila estiver vazia
	 */

	@Override
	public NodoListaEncadeada<Integer> verificarCabeca() {
		NodoListaEncadeada<Integer> primeiro = fila.getCabeca().getProximo();
		return primeiro.isNull() ? null : primeiro;
	}

	@Override
	public boolean isEmpty() {
		return fila.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false; // lista encadeada é dinâmica
	}

	@Override
	public int capacidade() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Retorna o número de elementos atualmente na fila.
	 *
	 * @return a quantidade de elementos
	 */
	@Override
	public int tamanho() {
		int contador = 0;
		NodoListaEncadeada<Integer> atual = fila.getCabeca().getProximo();

		while (!atual.isNull()) {
			contador++;
			atual = atual.getProximo();
		}

		return contador;
	}

}
