package org.example.b3stocks.tad.conjuntoDinamico;

import org.example.b3stocks.tad.ElementoNaoEncontradoException;

/**
 * Implementação genérica encadeada do TAD Conjunto Dinâmico.
 *
 * <p>Esta estrutura armazena elementos de forma dinâmica usando uma lista
 * encadeada simples. Permite realizar operações como inserção, remoção, busca,
 * cálculo de mínimo/máximo, bem como obtenção de predecessor e sucessor.</p>
 *
 * <p>Duplicatas são evitadas com base na lógica da operação {@code buscar()},
 * que impede inserções de elementos já existentes.</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.1</p>
 */
public class MeuConjuntoDinamicoEncadeado<T extends Comparable<T>> implements ConjuntoDinamicoIF<T> {

	private static class No<T> {
		T valor;
		No<T> proximo;

		No(T valor) {
			this.valor = valor;
		}
	}

	private No<T> cabeca;
	private int tamanho = 0;

	@Override
	public void inserir(T item) throws ElementoNaoEncontradoException {
		if (item == null) return;
		try {
			buscar(item); // já existe?
			return;
		} catch (ElementoNaoEncontradoException ignored) {
			// segue para inserção
		}

		No<T> novo = new No<>(item);

		if (cabeca == null) {
			cabeca = novo;
		} else {
			No<T> atual = cabeca;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novo;
		}

		tamanho++;
	}

	@Override
	public T remover(T item) throws ConjuntoDinamicoVazioException, ElementoNaoEncontradoException {
		if (cabeca == null) {
			throw new ConjuntoDinamicoVazioException();
		}

		if (cabeca.valor.equals(item)) {
			T removido = cabeca.valor;
			cabeca = cabeca.proximo;
			tamanho--;
			return removido;
		}

		No<T> anterior = cabeca;
		No<T> atual = cabeca.proximo;

		while (atual != null) {
			if (atual.valor.equals(item)) {
				anterior.proximo = atual.proximo;
				tamanho--;
				return atual.valor;
			}
			anterior = atual;
			atual = atual.proximo;
		}

		throw new ElementoNaoEncontradoException("Item não encontrado: " + item);
	}

	@Override
	public T predecessor(T item) {
		T pred = null;
		No<T> atual = cabeca;
		while (atual != null) {
			if (atual.valor.compareTo(item) < 0) {
				if (pred == null || atual.valor.compareTo(pred) > 0) {
					pred = atual.valor;
				}
			}
			atual = atual.proximo;
		}
		return pred;
	}

	@Override
	public T sucessor(T item) {
		T suc = null;
		No<T> atual = cabeca;
		while (atual != null) {
			if (atual.valor.compareTo(item) > 0) {
				if (suc == null || atual.valor.compareTo(suc) < 0) {
					suc = atual.valor;
				}
			}
			atual = atual.proximo;
		}
		return suc;
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public T buscar(T item) throws ElementoNaoEncontradoException {
		No<T> atual = cabeca;
		while (atual != null) {
			if (atual.valor.equals(item)) {
				return atual.valor;
			}
			atual = atual.proximo;
		}
		throw new ElementoNaoEncontradoException("Item não encontrado: " + item);
	}

	@Override
	public T minimum() {
		if (cabeca == null) return null;

		T min = cabeca.valor;
		No<T> atual = cabeca.proximo;
		while (atual != null) {
			if (atual.valor.compareTo(min) < 0) {
				min = atual.valor;
			}
			atual = atual.proximo;
		}
		return min;
	}

	@Override
	public T maximum() {
		if (cabeca == null) return null;

		T max = cabeca.valor;
		No<T> atual = cabeca.proximo;
		while (atual != null) {
			if (atual.valor.compareTo(max) > 0) {
				max = atual.valor;
			}
			atual = atual.proximo;
		}
		return max;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[tamanho];
		int i = 0;
		No<T> atual = cabeca;
		while (atual != null) {
			array[i++] = atual.valor;
			atual = atual.proximo;
		}
		return array;
	}
}
