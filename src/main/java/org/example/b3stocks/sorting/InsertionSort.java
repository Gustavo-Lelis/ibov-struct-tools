package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;
import org.example.b3stocks.util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort {

    public final DataBovespa[] vector;

    public InsertionSort(DataBovespa[] vetor) {
        if (vetor == null) {
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vector = vetor;
    }

    public DataBovespa[] ordenarPor(Comparator<DataBovespa> comparator) {
        if (this.vector.length <= 1) {
            return Arrays.copyOf(this.vector, this.vector.length);
        }
        DataBovespa[] copia = Arrays.copyOf(this.vector, this.vector.length);

        for (int j = 1; j < copia.length; j++) {
            DataBovespa key = copia[j];
            int i = j - 1;

            // CORRETO: move os maiores para a direita
            while (i >= 0 && comparator.compare(copia[i], key) > 0) {
                copia[i + 1] = copia[i];
                i--;
            }
            copia[i + 1] = key;
        }

        return copia;
    }


    private DataBovespa[] inverterArray(DataBovespa[] array) {
        DataBovespa[] invertido = Arrays.copyOf(array, array.length);
        for (int i = 0; i < invertido.length / 2; i++) {
            DataBovespa temp = invertido[i];
            invertido[i] = invertido[invertido.length - 1 - i];
            invertido[invertido.length - 1 - i] = temp;
        }
        return invertido;
    }


    public DataBovespa[] insertionSortPorVolume() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getVolume));
    }

    public DataBovespa[] insertionSortPorVolumeMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getVolume));
        return new InsertionSort(ordenado).insertionSortPorVolume();
    }

    public DataBovespa[] insertionSortPorVolumePiorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getVolume).reversed());
        return new InsertionSort(ordenado).insertionSortPorVolume();
    }

    public DataBovespa[] insertionSortPorVolumeMedioCaso() {
        DataBovespa[] embaralhado = ArrayUtils.embaralharArray(Arrays.copyOf(vector, vector.length));
        return new InsertionSort(embaralhado).insertionSortPorVolume();
    }

    public DataBovespa[] insertionSortPorTicker() {
        return ordenarPor(Comparator.comparing(DataBovespa::getTicker));
    }

    public DataBovespa[] insertionSortPorTickerMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparing(DataBovespa::getTicker));
        return new InsertionSort(ordenado).insertionSortPorTicker();
    }

    public DataBovespa[] insertionSortPorTickerPiorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparing(DataBovespa::getTicker).reversed());
        return new InsertionSort(ordenado).insertionSortPorTicker();
    }

    public DataBovespa[] insertionSortPorTickerMedioCaso() {
        DataBovespa[] embaralhado = ArrayUtils.embaralharArray(Arrays.copyOf(vector, vector.length));
        return new InsertionSort(embaralhado).insertionSortPorTicker();
    }


    public DataBovespa[] insertionSortPorFlutuacao() {
        return ordenarPor(Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
    }

    public DataBovespa[] insertionSortPorFlutuacaoMelhorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getFlutuacao).reversed());
        return new InsertionSort(ordenado).insertionSortPorFlutuacao();
    }

    public DataBovespa[] insertionSortPorFlutuacaoPiorCaso() {
        DataBovespa[] ordenado = Arrays.copyOf(vector, vector.length);
        Arrays.sort(ordenado, Comparator.comparingDouble(DataBovespa::getFlutuacao));
        return new InsertionSort(ordenado).insertionSortPorFlutuacao();
    }

    public DataBovespa[] insertionSortPorFlutuacaoMedioCaso() {
        DataBovespa[] embaralhado = ArrayUtils.embaralharArray(Arrays.copyOf(vector, vector.length));
        return new InsertionSort(embaralhado).insertionSortPorFlutuacao();
    }



}
