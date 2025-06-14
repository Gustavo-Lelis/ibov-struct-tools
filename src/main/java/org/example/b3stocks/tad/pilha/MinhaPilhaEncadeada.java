package org.example.b3stocks.tad.pilha;


import org.example.b3stocks.tad.listasEncadeadas.NodoListaEncadeada;

/**
 * Implementação de pilha baseada em lista encadeada.
 *
 * <p>Utiliza inserções no início da lista para representar empilhamento e
 * remoções da cabeça para o desempilhamento. Não possui limite de capacidade.</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João
 *   Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.0</p>
 */

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {

	private NodoListaEncadeada<Integer> cabeca;;
	/**
	 * Insere um novo item no topo da pilha.
	 *
	 * @param item Elemento a ser empilhado
	 */
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		NodoListaEncadeada<Integer> novoNo = new NodoListaEncadeada<>(item);
		novoNo.setProximo(cabeca);
		cabeca = novoNo;
	}
	/**
	 * Remove e retorna o elemento no topo da pilha.
	 *
	 * @return Elemento removido do topo
	 * @throws PilhaVaziaException caso a pilha esteja vazia
	 */
	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) throw new PilhaVaziaException();

		Integer topo = cabeca.getChave();
		cabeca = cabeca.getProximo();
		return topo;
	}
	/**
	 * Retorna o elemento no topo da pilha sem removê-lo.
	 *
	 * @return Elemento no topo ou {@code null} se a pilha estiver vazia
	 */
	@Override
	public Integer topo() {
		if (isEmpty()) return null;
		return cabeca.getChave();
	}
	/**
	 * Retorna uma nova pilha com até {@code k} elementos do topo da pilha atual.
	 *
	 * @param k quantidade de elementos a copiar
	 * @return nova pilha contendo os {@code k} elementos superiores da pilha atual
	 */
	@Override
	public PilhaIF<Integer> multitop(int k) {
		MinhaPilhaEncadeada pilhaAux = new MinhaPilhaEncadeada();
		NodoListaEncadeada<Integer> atual = cabeca;
		int count = 0;
		while (atual != null && count < k) {
			try {
				pilhaAux.empilhar(atual.getChave());
			} catch (PilhaCheiaException e) {
				break;
			}
			atual = atual.getProximo();
			count++;
		}
		return pilhaAux;
	}

	/**
	 * Verifica se a pilha está vazia.
	 *
	 * @return {@code true} se estiver vazia, {@code false} caso contrário
	 */
	@Override
	public boolean isEmpty() {
		return cabeca == null;
	}
	/**
	 * Retorna a capacidade teórica da pilha (ilimitada).
	 *
	 * @return {@link Integer#MAX_VALUE}
	 */
	@Override
	public int capacidade() {
		return Integer.MAX_VALUE;
	}
	/**
	 * Retorna a quantidade de elementos atualmente na pilha.
	 *
	 * @return tamanho da pilha
	 */
	@Override
	public int tamanho() {
		int count = 0;
		NodoListaEncadeada<Integer> atual = cabeca;
		while (atual != null) {
			count++;
			atual = atual.getProximo();
		}
		return count;
	}
}
