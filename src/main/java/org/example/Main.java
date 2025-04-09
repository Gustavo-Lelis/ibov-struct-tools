package org.example;


import org.example.entity.DataBovespa;
import org.example.repository.FileRepository;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileRepository fileRepository = new FileRepository();
        DataBovespa[] dados = fileRepository.getDataBovespa();
        String outFile = "src\\main\\resources\\b3stocks_T1.csv";
        fileRepository.writeToFile(outFile, dados);
        fileRepository.getMaxVolumeRecordPerDay("src\\main\\resources\\b3stocks_F1.csv",dados);

    }
}