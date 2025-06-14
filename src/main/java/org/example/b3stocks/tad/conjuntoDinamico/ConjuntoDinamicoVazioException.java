package org.example.b3stocks.tad.conjuntoDinamico;

public class ConjuntoDinamicoVazioException extends Exception {
    public ConjuntoDinamicoVazioException() {
        super("Conjunto dinâmico Vazio!!!");
    }
    public ConjuntoDinamicoVazioException(String msg) {
        super(msg);
    }
}
