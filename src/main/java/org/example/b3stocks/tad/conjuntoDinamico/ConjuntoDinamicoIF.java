package org.example.b3stocks.tad.conjuntoDinamico;

import org.example.b3stocks.tad.ElementoNaoEncontradoException;
import org.example.b3stocks.tad.ElementoNaoEncontradoException;

public interface ConjuntoDinamicoIF<E> {
	void inserir(E item) throws ElementoNaoEncontradoException;
	E remover(E item) throws ConjuntoDinamicoVazioException, ElementoNaoEncontradoException;
	E predecessor(E item) throws ConjuntoDinamicoVazioException;
	E sucessor(E item) throws ConjuntoDinamicoVazioException;
	int tamanho();
	E buscar(E item) throws ElementoNaoEncontradoException,  ConjuntoDinamicoVazioException;
	E minimum() throws ConjuntoDinamicoVazioException;
	E maximum() throws ConjuntoDinamicoVazioException;
	E[] toArray();

}

