package org.example;


import org.example.entity.DateBovespa;
import org.example.repository.FileRepository;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileRepository fileRepository = new FileRepository();
        DateBovespa[] dados = fileRepository.getDateBovespa("src\\main\\resources\\b3_stocks_1994_2020.csv");
        String outFile = "src\\main\\resources\\b3_stocks_T1.csv";
        fileRepository.writeToFile(outFile, dados);

    }
}