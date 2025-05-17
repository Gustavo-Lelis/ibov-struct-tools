package org.example.b3stocks.sorting;

import org.example.b3stocks.model.DataBovespa;

import java.util.Arrays;
import java.util.Comparator;

public class CountingSort {
    public final DataBovespa[] vector;

    public CountingSort(DataBovespa[] vetor) {
        if (vetor == null) {
            throw new IllegalArgumentException("Vetor não pode ser nulo");
        }
        this.vector = vetor;
    }

    public void gerarcountingSort(DataBovespa[] baseDeDados){

        DataBovespa[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("________________________COUNTING SORT________________________");
        System.out.println();
        System.out.println("ORDEM ALFABETICA: ");

        System.out.println("Não é possível ordenar através do Counting Sort!");

        System.out.println();
        System.out.println("VOLUME: ");
        System.out.println();
        System.out.println("Não é possível ordenar através do Counting Sort (Valores do tipo float)!");

        System.out.println();
        System.out.println("VARIACOES: ");
        System.out.println();
        System.out.println("Não é possível ordenar através do Counting Sort (Valores do tipo float)!");

    }




}
