package org.example.b3stocks.tad.conjuntoDinamico;

import org.example.b3stocks.tad.ElementoNaoEncontradoException;

/**
 * Implementação do TAD Conjunto Dinâmico utilizando um array redimensionável.
 *
 * <p>Esta classe permite armazenar, buscar, remover e consultar informações
 * como o menor, maior, predecessor e sucessor de elementos inteiros.</p>
 *
 * <p>O array interno cresce automaticamente quando o limite é atingido. Duplicatas
 * são permitidas, e os elementos não são mantidos ordenados.</p>
 *
 * <p>Utiliza exceções personalizadas para tratamento de conjunto vazio e elementos
 * inexistentes, como {@code ConjuntoDinamicoVazioException} e {@code ElementoNaoEncontradoException}.</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João
 * Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.0</p>
 */

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

	private Integer[] meusDados = new Integer[1];
	private int posInsercao = 0;

	@Override
	public Integer[] toArray() {
		return new Integer[0];
	}

	/**
	 * Insere um novo elemento no conjunto, se ele ainda não estiver presente.
	 *
	 * @param item o valor inteiro a ser inserido
	 * @throws IllegalArgumentException se o item for null
	 */

	@Override
	public void inserir(Integer item) throws IllegalArgumentException {

		if (posInsercao == meusDados.length) {
			meusDados = aumentarArray();
		}
		meusDados[posInsercao++] = item;
	}

	private Integer[] aumentarArray() {
		int novoTamanho = meusDados.length * 2;
		Integer[] novoArray = new Integer[novoTamanho];
		for (int i = 0; i < meusDados.length; i++) {
			novoArray[i] = meusDados[i];
		}
		return novoArray;
	}

	/**
	 * Remove a primeira ocorrência de um item no conjunto.
	 *
	 * @param item o valor a ser removido
	 * @return o valor removido
	 * @throws ConjuntoDinamicoVazioException se o conjunto estiver vazio
	 * @throws ElementoNaoEncontradoException se o item não for encontrado
	 * @throws IllegalArgumentException se o item for null
	 */

	@Override
	public Integer remover(Integer item) throws ConjuntoDinamicoVazioException, ElementoNaoEncontradoException {
		if (posInsercao == 0) {
			throw new ConjuntoDinamicoVazioException("Elemento não pode ser null");
		}
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				Integer removido = meusDados[i];
				for (int j = i; j < posInsercao - 1; j++) {
					meusDados[j] = meusDados[j + 1];
				}
				meusDados[--posInsercao] = null;
				return removido;
			}
		}
		throw new ElementoNaoEncontradoException("Elemento nao encontrado!!");
	}

	@Override
	public Integer buscar(Integer item) throws ElementoNaoEncontradoException {
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				return meusDados[i];
			}
		}
		throw new ElementoNaoEncontradoException("Elemento nao encontrado!!");
	}

	@Override
	public Integer predecessor(Integer item) throws ConjuntoDinamicoVazioException {
		if (posInsercao == 0) throw new ConjuntoDinamicoVazioException("Conjunto dinâmico Vazio!!!");
		Integer pred = null;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] < item) {
				if (pred == null || meusDados[i] > pred) {
					pred = meusDados[i];
				}
			}
		}
		return pred; // sem lançar exceção se não existir
	}

	/**
	 * Retorna o sucessor imediato de um valor no conjunto.
	 *
	 * @param item valor de referência
	 * @return o sucessor mais próximo, ou {@code null} se não houver
	 * @throws ConjuntoDinamicoVazioException se o conjunto estiver vazio
	 */

	@Override
	public Integer sucessor(Integer item) throws ConjuntoDinamicoVazioException {
		if (posInsercao == 0) throw new ConjuntoDinamicoVazioException("Conjunto dinâmico Vazio!!!");
		Integer suc = null;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] > item) {
				if (suc == null || meusDados[i] < suc) {
					suc = meusDados[i];
				}
			}
		}
		return suc; // sem lançar exceção se não existir
	}



	@Override
	public int tamanho() {
		return posInsercao;
	}

	/**
	 * Retorna o menor valor do conjunto.
	 *
	 * @return o valor mínimo
	 * @throws ConjuntoDinamicoVazioException se o conjunto estiver vazio
	 */

	@Override
	public Integer minimum() throws ConjuntoDinamicoVazioException {
		if (posInsercao == 0) throw new ConjuntoDinamicoVazioException("Conjunto dinâmico Vazio!!!");
		int min = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i] < min) {
				min = meusDados[i];
			}
		}
		return min;
	}

	@Override
	public Integer maximum() throws ConjuntoDinamicoVazioException {
		if (posInsercao == 0) throw new ConjuntoDinamicoVazioException("Conjunto dinâmico Vazio!!!");
		int max = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i] > max) {
				max = meusDados[i];
			}
		}
		return max;
	}

}
