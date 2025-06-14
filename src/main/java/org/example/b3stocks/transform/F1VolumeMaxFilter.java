package org.example.b3stocks.transform;

import org.example.b3stocks.model.DataBovespa;
import org.example.b3stocks.tad.conjuntoDinamico.ConjuntoDinamicoIF;
import org.example.b3stocks.tad.conjuntoDinamico.MeuConjuntoDinamicoEncadeado;
import org.example.b3stocks.tad.conjuntoDinamico.ConjuntoDinamicoVazioException;
import org.example.b3stocks.tad.ElementoNaoEncontradoException;

public class F1VolumeMaxFilter {

    public static ConjuntoDinamicoIF<DataBovespa> getMaxVolumeRecordPerDay(DataBovespa[] dados) {
        ConjuntoDinamicoIF<DataBovespa> conjunto = new MeuConjuntoDinamicoEncadeado<>();

        for (DataBovespa atual : dados) {
            if (atual == null || atual.getDateTime() == null) continue;

            boolean substituido = false;

            for (DataBovespa existente : conjunto.toArray()) {
                if (existente.getDateTime().equals(atual.getDateTime())) {
                    if (atual.getVolume() > existente.getVolume()) {
                        try {
                            conjunto.remover(existente);
                            conjunto.inserir(atual);
                        } catch (Exception e) {
                            throw new RuntimeException("Erro ao substituir item", e);
                        }
                    }
                    substituido = true;
                    break;
                }
            }

            if (!substituido) {
                try {
                    conjunto.inserir(atual);
                } catch (ElementoNaoEncontradoException e) {
                    throw new RuntimeException("Erro ao inserir item novo", e);
                }
            }
        }

        return conjunto;
    }
}
