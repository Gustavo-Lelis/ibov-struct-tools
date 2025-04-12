package org.example.b3stocks.util;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;

public class ArrayUtils {
    public static DataBovespa[] aumentarCapacidade(DataBovespa[] original) {
        return Arrays.copyOf(original, original.length * 2);
    }
}
