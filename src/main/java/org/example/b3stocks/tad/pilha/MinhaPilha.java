package org.example.b3stocks.tad.pilha;
/**
 * Implementação de pilha com array fixo.
 *
 * <p>A pilha segue o modelo LIFO (Last-In, First-Out) com operações de empilhar,
 * desempilhar e visualização do topo. O array é limitado por uma capacidade fixa.</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João
 *   Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.0</p>
 */

public class MinhaPilha implements PilhaIF<Integer> {

	private int capacidade = 10;
	private Integer[] meusDados;
	private int topo = -1;
	/**
	 * Construtor com capacidade definida pelo usuário.
	 *
	 * @param tamanho Capacidade máxima da pilha
	 */
	public MinhaPilha(int tamanho) {
		this.capacidade = tamanho;
		this.meusDados = new Integer[capacidade];
	}
	/**
	 * Construtor padrão com capacidade de 10 elementos.
	 */
	public MinhaPilha() {
		this.meusDados = new Integer[capacidade];
	}
	/**
	 * Empilha um novo elemento no topo da pilha.
	 *
	 * @param item Elemento a ser empilhado
	 * @throws PilhaCheiaException caso a pilha esteja cheia
	 */
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if (topo == meusDados.length - 1) {
			throw new PilhaCheiaException();
		} else {
			meusDados[++topo] = item;
		}
	}

	/**
	 * Desempilha o elemento do topo da pilha.
	 *
	 * @return Elemento removido do topo
	 * @throws PilhaVaziaException caso a pilha esteja vazia
	 */
	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		return meusDados[topo--];
	}
	/**
	 * Retorna o elemento no topo da pilha sem removê-lo.
	 *
	 * @return Elemento do topo ou null se a pilha estiver vazia
	 */
	@Override
	public Integer topo() {
		if (isEmpty()) return null;
		return meusDados[topo];
	}
	/**
	 * Cria uma nova pilha com os k elementos do topo da pilha atual.
	 *
	 * @param k Quantidade de elementos a copiar
	 * @return Nova pilha com os k elementos do topo ou null se k for inválido
	 */
	@Override
	public PilhaIF<Integer> multitop(int k) throws PilhaVaziaException {
		if (k <= 0) {
			throw new IllegalArgumentException("O parâmetro k precisa ser maior que zero");
		}
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}


		int limite = Math.min(k, tamanho());

		MinhaPilha nova = new MinhaPilha(limite);
		for (int i = topo; i > topo - limite; i--) {
			try {
				nova.empilhar(meusDados[i]);
			} catch (PilhaCheiaException e) {
				throw new RuntimeException(e);
			}
		}

		return nova;
	}

	/**
	 * Verifica se a pilha está vazia.
	 *
	 * @return true se estiver vazia, false caso contrário
	 */
	@Override
	public boolean isEmpty() {
		return topo == -1;
	}
	/**
	 * Retorna a capacidade máxima da pilha.
	 *
	 * @return capacidade
	 */
	@Override
	public int capacidade() {
		return meusDados.length;
	}
	/**
	 * Retorna o número de elementos atualmente na pilha.
	 *
	 * @return tamanho atual
	 */

	@Override
	public int tamanho() {
		return topo + 1;
	}

	/**
	 * Compara esta pilha com outro objeto para verificar igualdade.
	 * Duas pilhas são iguais se têm o mesmo tamanho e os mesmos elementos na mesma ordem.
	 *
	 * @param obj o objeto a ser comparado
	 * @return true se forem iguais, false caso contrário
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		MinhaPilha outra = (MinhaPilha) obj;

		if (this.topo != outra.topo)
			return false;

		for (int i = 0; i <= topo; i++) {
			if (!this.meusDados[i].equals(outra.meusDados[i])) {
				return false;
			}
		}

		return true;
	}
}
