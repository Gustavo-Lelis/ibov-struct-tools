package org.example.b3stocks.tad;

public class ElementoNaoEncontradoException extends Exception {

    public ElementoNaoEncontradoException() {
        super("Elemento nao encontrado!!");
    }

    public ElementoNaoEncontradoException(String msg) {
        super(msg);
    }
}
