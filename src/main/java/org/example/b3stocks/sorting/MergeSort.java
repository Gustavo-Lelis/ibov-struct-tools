package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    private final DataBovespa[] vector;

    public MergeSort(DataBovespa[] vetor) {
        if (vetor == null) {
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vector = vetor;
    }

    public DataBovespa[] ordenarPor(Comparator<DataBovespa> comparator) {
        DataBovespa[] copia = Arrays.copyOf(this.vector, this.vector.length);
        DataBovespa[] aux = new DataBovespa[copia.length];
        mergeSort(copia, aux, 0, copia.length - 1, comparator);
        return copia;
    }

    private void mergeSort(DataBovespa[] v, DataBovespa[] aux, int left, int right, Comparator<DataBovespa> comp) {
        if (left >= right) return;

        int middle = (left + right) / 2;

        mergeSort(v, aux, left, middle, comp);
        mergeSort(v, aux, middle + 1, right, comp);
        merge(v, aux, left, middle, right, comp);
    }

    private void merge(DataBovespa[] v, DataBovespa[] aux, int left, int middle, int right, Comparator<DataBovespa> comp) {
        // Copia apenas o trecho relevante para o auxiliar
        System.arraycopy(v, left, aux, left, right - left + 1);

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (comp.compare(aux[i], aux[j]) <= 0) {
                v[k++] = aux[i++];
            } else {
                v[k++] = aux[j++];
            }
        }

        // Copia o resto do lado esquerdo (se houver)
        while (i <= middle) {
            v[k++] = aux[i++];
        }
        // Não precisa copiar o lado direito, pois já está no lugar
    }

    public DataBovespa[] mergeSortPorVolume() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }

    public DataBovespa[] mergeSortPorTicker() {
        return ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }

    public DataBovespa[] mergeSortPorFlutuacao() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }
}
