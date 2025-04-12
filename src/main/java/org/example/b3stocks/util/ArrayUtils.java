package org.example.b3stocks.util;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;

public class ArrayUtils {
    public static DataBovespa[] aumentarCapacidade(DataBovespa[] original) {
        try{
            DataBovespa[] novoArray = new DataBovespa[original.length * 2];
            for (int i = 0; i < original.length; i++) {
                novoArray[i] = original[i];
            }
            return novoArray;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
