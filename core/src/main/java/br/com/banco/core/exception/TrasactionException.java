package br.com.banco.core.exception;

public class TrasactionException extends Exception {

    private String code;

    public TrasactionException(String message, String code) {
        super(message);
        this.code = code;
    }
}
