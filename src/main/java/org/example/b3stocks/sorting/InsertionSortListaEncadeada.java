package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;
import org.example.b3stocks.tad.listasEncadeadas.ListaEncadeadaImpl;
import org.example.b3stocks.tad.listasEncadeadas.NodoListaEncadeada;

public class InsertionSortListaEncadeada {

    public static void ordenarPorTicker(ListaEncadeadaImpl<DataBovespa> lista) {
        if (lista.isEmpty() || lista.size() == 1) return;

        NodoListaEncadeada<DataBovespa> atual = lista.getCabeca().getProximo().getProximo();

        while (atual != lista.getCauda()) {
            DataBovespa chave = atual.getChave();
            NodoListaEncadeada<DataBovespa> anterior = lista.getCabeca().getProximo();
            NodoListaEncadeada<DataBovespa> anteriorAnterior = lista.getCabeca();

            NodoListaEncadeada<DataBovespa> proximoAtual = atual.getProximo();
            try {
                lista.remove(chave);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao remover: " + chave.getTicker(), e);
            }

            while (anterior != lista.getCauda()
                    && anterior.getChave().getTicker().compareTo(chave.getTicker()) < 0) {
                anteriorAnterior = anterior;
                anterior = anterior.getProximo();
            }

            NodoListaEncadeada<DataBovespa> novo = new NodoListaEncadeada<>(chave);
            novo.setProximo(anterior);
            anteriorAnterior.setProximo(novo);

            atual = proximoAtual;
        }
    }

    public static void ordenarPorVolume(ListaEncadeadaImpl<DataBovespa> lista) {
        if (lista.isEmpty() || lista.size() == 1) return;

        NodoListaEncadeada<DataBovespa> atual = lista.getCabeca().getProximo().getProximo();

        while (atual != lista.getCauda()) {
            DataBovespa chave = atual.getChave();
            NodoListaEncadeada<DataBovespa> anterior = lista.getCabeca().getProximo();
            NodoListaEncadeada<DataBovespa> anteriorAnterior = lista.getCabeca();

            NodoListaEncadeada<DataBovespa> proximoAtual = atual.getProximo();
            try {
                lista.remove(chave);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao remover: " + chave.getTicker(), e);
            }

            while (anterior != lista.getCauda()
                    && anterior.getChave().getVolume() < chave.getVolume()) {
                anteriorAnterior = anterior;
                anterior = anterior.getProximo();
            }

            NodoListaEncadeada<DataBovespa> novo = new NodoListaEncadeada<>(chave);
            novo.setProximo(anterior);
            anteriorAnterior.setProximo(novo);

            atual = proximoAtual;
        }
    }

    public static void ordenarPorFlutuacao(ListaEncadeadaImpl<DataBovespa> lista) {
        if (lista.isEmpty() || lista.size() == 1) return;

        NodoListaEncadeada<DataBovespa> atual = lista.getCabeca().getProximo().getProximo();

        while (atual != lista.getCauda()) {
            DataBovespa chave = atual.getChave();
            NodoListaEncadeada<DataBovespa> anterior = lista.getCabeca().getProximo();
            NodoListaEncadeada<DataBovespa> anteriorAnterior = lista.getCabeca();

            NodoListaEncadeada<DataBovespa> proximoAtual = atual.getProximo();
            try {
                lista.remove(chave);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao remover: " + chave.getTicker(), e);
            }

            while (anterior != lista.getCauda()
                    && anterior.getChave().getFlutuacao() > chave.getFlutuacao()) {
                anteriorAnterior = anterior;
                anterior = anterior.getProximo();
            }

            NodoListaEncadeada<DataBovespa> novo = new NodoListaEncadeada<>(chave);
            novo.setProximo(anterior);
            anteriorAnterior.setProximo(novo);

            atual = proximoAtual;
        }
    }
}

