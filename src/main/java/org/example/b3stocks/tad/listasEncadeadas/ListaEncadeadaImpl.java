package org.example.b3stocks.tad.listasEncadeadas;
import org.example.b3stocks.tad.ElementoNaoEncontradoException;
/**
 * Implementação de uma lista simplesmente encadeada com sentinela de cauda.
 *
 * <p>Suporta operações básicas de inserção, remoção, busca, impressão em ordem e inversa,
 * além de conversão para array e localização de sucessores e predecessores.</p>
 *
 * <p><strong>Autor:</strong> Gustavo Farias, João
 * Victor Marinho<br>
 * <strong>Data:</strong> 03/06/2025<br>
 * <strong>Versão:</strong> 1.0</p>
 */

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T> {
    NodoListaEncadeada<T> cabeca = null;


    NodoListaEncadeada<T> cauda = null;


    private int tamanho = 0;

    public ListaEncadeadaImpl() {
        cabeca = new NodoListaEncadeada<T>();
        cauda = new NodoListaEncadeada<T>();
        cabeca.setProximo(cauda);
    }

    @Override
    public boolean isEmpty(){
        return tamanho == 0;
    }
    @Override
    public int size(){
        return tamanho;
    }
    @Override
    public NodoListaEncadeada<T> search(T chave){
        if(isEmpty()){
            return null;
        }

        NodoListaEncadeada<T> atual = cabeca.getProximo();
        while(atual != null && atual != cauda){
            if(chave == null) {
                if(atual.getChave() == null){
                    return atual;
                }
            } else {
                if(atual.getChave() != null && atual.getChave().compareTo(chave) == 0){
                    return atual;
                }
            }
            atual = atual.getProximo();
        }
        return null;
    }
    @Override
    public void insert(T chave) {
        NodoListaEncadeada<T> novo = new NodoListaEncadeada<>(chave);
        NodoListaEncadeada<T> atual = cabeca;

        while(atual.getProximo() != cauda){
            atual = atual.getProximo();
        }

        novo.setProximo(cauda);
        atual.setProximo(novo);
        tamanho++;

    }
    /**
     * Remove o nó que contém a chave fornecida.
     *
     * @param chave Elemento a ser removido
     * @return Nó removido
     * @throws ElementoNaoEncontradoException se o elemento não for encontrado na lista
     */
    @Override
    public NodoListaEncadeada<T> remove(T chave) throws ElementoNaoEncontradoException, ListaVaziaException {
        if (isEmpty()) {
            throw new ListaVaziaException();
        }

        NodoListaEncadeada<T> anterior = cabeca;
        NodoListaEncadeada<T> atual = cabeca.getProximo();

        while (!atual.equals(cauda) && atual.getChave().compareTo(chave) != 0) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual.equals(cauda)) {
            throw new ElementoNaoEncontradoException();
        }

        anterior.setProximo(atual.getProximo());
        atual.setProximo(null);
        tamanho--;
        return atual;
    }
    /**
     * Converte os elementos da lista para um array do tipo informado.
     *
     * @param clazz Tipo da classe dos elementos
     * @return Array contendo os elementos da lista
     */
    @Override
    public T[] toArray(Class<T> clazz) {
        int tamanho = size();
        @SuppressWarnings("unchecked")
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, tamanho);

        NodoListaEncadeada<T> atual = cabeca.getProximo();
        int i = 0;
        while (atual != cauda && i < tamanho) {
            array[i++] = atual.getChave();
            atual = atual.getProximo();
        }
        return array;
    }
    /**
     * Imprime a lista do primeiro ao último elemento (excluindo sentinelas).
     *
     * @return String com os elementos separados por espaço
     */
    @Override
    public String imprimeEmOrdem(){
        if(isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        NodoListaEncadeada<T> atual = cabeca.getProximo();

        while(atual != null && atual != cauda){
            sb.append(atual.getChave());
            if(atual.getProximo() != null && atual.getProximo() != cauda){
                sb.append(", ");
            }
            atual = atual.getProximo();
        }

        return sb.toString();

    }
    /**
     * Imprime a lista do último ao primeiro elemento usando recursão.
     *
     * @return String com os elementos na ordem inversa separados por espaço
     */
    @Override
    public String imprimeInverso(){
        if(isEmpty()){
            return "";
        }

        return imprimeInversoRec(cabeca.getProximo()).toString();

    }

    private StringBuilder imprimeInversoRec(NodoListaEncadeada<T> nodo){
        if(nodo == null || nodo == cauda){
            return new StringBuilder();
        }
        StringBuilder sb = imprimeInversoRec(nodo.getProximo());
        if(sb.length() > 0){
            sb.append(", ");
        }
        sb.append(nodo.getChave());
        return sb;
    }
    /**
     * Retorna o sucessor de um dado elemento, se houver.
     *
     * @param chave Elemento de referência
     * @return Nó sucessor
     * @throws ElementoNaoEncontradoException se o elemento não for encontrado ou for o último da lista
     */
    @Override
    public NodoListaEncadeada<T> sucessor(T chave) throws ElementoNaoEncontradoException {
        NodoListaEncadeada<T> nodo = search(chave);
        if(nodo == null){
            throw new ElementoNaoEncontradoException();
        }
        return nodo.getProximo();
    }
    /**
     * Retorna o predecessor de um dado elemento, se houver.
     *
     * @param chave Elemento de referência
     * @return Nó predecessor
     * @throws ElementoNaoEncontradoException se o elemento não for encontrado ou for o primeiro da lista
     */
    @Override
    public NodoListaEncadeada<T> predecessor(T chave) throws ElementoNaoEncontradoException {
        if (isEmpty()) {
            throw new ElementoNaoEncontradoException();
        }

        NodoListaEncadeada<T> anterior = cabeca;
        NodoListaEncadeada<T> atual = cabeca.getProximo();

        while (atual != null && atual != cauda) {
            if (atual.getChave().compareTo(chave) == 0) {
                if (anterior.equals(cabeca)) {
                    return null;
                } else {
                    return anterior;
                }
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        throw new ElementoNaoEncontradoException();
    }

    /**
     * Insere um novo nó com a chave informada na posição especificada.
     * Caso o índice seja inválido, uma exceção será lançada.
     *
     * @param chave Elemento a ser inserido
     * @param index Índice onde será inserido
     * @return
     * @throws IndexOutOfBoundsException se o índice for negativo ou maior que o tamanho da lista
     */
    @Override
    public void insert(T chave, int index) {
        if(index < 0 || index > tamanho){
            throw new IndexOutOfBoundsException("Índice fora do intervalo");
        }

        NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<>(chave);
        NodoListaEncadeada<T> atual = cabeca;
        for(int i = 0; i < index; i++){
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);
        tamanho++;
    }
    public NodoListaEncadeada<T> getCauda() {
        return this.cauda;
    }


    public NodoListaEncadeada<T> getCabeca() {
        return this.cabeca;
    }

}
