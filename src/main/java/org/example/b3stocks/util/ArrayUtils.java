package org.example.b3stocks.util;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    private static final Random random = new Random();

    /**
     * Dobra a capacidade de um array mantendo seus valores.
     */
    public static DataBovespa[] aumentarCapacidade(DataBovespa[] original) {
        if (original == null) throw new IllegalArgumentException("Array original não pode ser nulo.");
        DataBovespa[] novoArray = new DataBovespa[original.length * 2];
        for (int i = 0; i < original.length; i++) {
            novoArray[i] = original[i];
        }
        return novoArray;
    }

    /**
     * Retorna uma nova cópia do array, mas com a ordem invertida.
     */
    public static DataBovespa[] inverterArray(DataBovespa[] array) {
        if (array == null) throw new IllegalArgumentException("Array não pode ser nulo.");
        DataBovespa[] invertido = Arrays.copyOf(array, array.length);
        for (int i = 0; i < invertido.length / 2; i++) {
            DataBovespa temp = invertido[i];
            invertido[i] = invertido[invertido.length - 1 - i];
            invertido[invertido.length - 1 - i] = temp;
        }
        return invertido;
    }

    /**
     * Embaralha o array original (in-place) usando Fisher–Yates shuffle.
     */
    public static DataBovespa[] embaralharArray(DataBovespa[] array) {
        if (array == null) throw new IllegalArgumentException("Array não pode ser nulo.");
        DataBovespa[] copia = Arrays.copyOf(array, array.length);
        for (int i = copia.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            DataBovespa temp = copia[i];
            copia[i] = copia[j];
            copia[j] = temp;
        }
        return copia;
    }
}
