package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Comparator;

public class SelectionSort {

    private final DataBovespa[] vector;

    public SelectionSort(DataBovespa[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vector = vector;
    }

    public DataBovespa[] ordenarPor(Comparator<DataBovespa> comparator) {
        if (this.vector.length <= 1) {
            return Arrays.copyOf(this.vector, this.vector.length);
        }
        DataBovespa[] copia = Arrays.copyOf(this.vector, this.vector.length);
        for (int i = 0; i < copia.length; i++) {
            int menorIndice = i;
            for (int j = i + 1; j < copia.length; j++) {
                if (comparator.compare(copia[menorIndice], copia[j]) > 0) {
                    menorIndice = j;
                }
            }
            DataBovespa aux = copia[i];
            copia[i] = copia[menorIndice];
            copia[menorIndice] = aux;
        }
        return copia;
    }

    public DataBovespa[] selectionSortPorVolume() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }

    public DataBovespa[] selectionSortPorVolumeMedioCaso() {
        return selectionSortPorVolume();
    }

    public DataBovespa[] selectionSortPorVolumeMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getVolume));
        SelectionSort sort = new SelectionSort(ordenado);
        return sort.selectionSortPorVolume();
    }

    public DataBovespa[] selectionSortPorVolumePiorCaso() {
        DataBovespa[] reverso = Arrays.copyOf(vector, vector.length);
        Arrays.sort(reverso, Comparator.comparingDouble(DataBovespa::getVolume).reversed());
        SelectionSort sort = new SelectionSort(reverso);
        return sort.selectionSortPorVolume();
    }

    public DataBovespa[] selectionSortPorTicker() {
        return ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }

    public DataBovespa[] selectionSortPorTickerMedioCaso() {
        return selectionSortPorTicker();
    }

    public DataBovespa[] selectionSortPorTickerMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparing(DataBovespa::getTicker));
        SelectionSort sort = new SelectionSort(ordenado);
        return sort.selectionSortPorTicker();
    }

    public DataBovespa[] selectionSortPorTickerPiorCaso() {
        DataBovespa[] reverso = Arrays.copyOf(vector, vector.length);
        Arrays.sort(reverso, Comparator.comparing(DataBovespa::getTicker).reversed());
        SelectionSort sort = new SelectionSort(reverso);
        return sort.selectionSortPorTicker();
    }

    public DataBovespa[] selectionSortPorFlutuacao() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }

    public DataBovespa[] selectionSortPorFlutuacaoMedioCaso() {
        return selectionSortPorFlutuacao();
    }

    public DataBovespa[] selectionSortPorFlutuacaoMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
        SelectionSort sort = new SelectionSort(ordenado);
        return sort.selectionSortPorFlutuacao();
    }

    public DataBovespa[] selectionSortPorFlutuacaoPiorCaso() {
        DataBovespa[] reverso = Arrays.copyOf(vector, vector.length);
        Arrays.sort(reverso, Comparator.comparingDouble(DataBovespa::getFlutuacao));
        SelectionSort sort = new SelectionSort(reverso);
        return sort.selectionSortPorFlutuacao();
    }

}
