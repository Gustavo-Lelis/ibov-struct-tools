package org.example.b3stocks.transform;

import org.example.b3stocks.model.DataBovespa;

import java.io.FileNotFoundException;

public class F2VolumeAboveAverage {

    public static DataBovespa[] getHigherValueDailyAverage(DataBovespa[] dados) throws FileNotFoundException {
        DataBovespa[] dataAux = new DataBovespa[dados.length];
        int index = 0;
        try{
            double i = 0;
            double valorTotal = 0;
            for(DataBovespa d : dados) {
                if (d != null) {
                    valorTotal += d.getVolume();
                    i++;
                }

            }

            double mediaTotal = valorTotal/i;

            for (DataBovespa dt : dados) {
                if (dt != null) {
                    if (dt.getVolume() > mediaTotal) {
                        dataAux[index++] = dt;
                    }
                }

            }
            return dataAux;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
