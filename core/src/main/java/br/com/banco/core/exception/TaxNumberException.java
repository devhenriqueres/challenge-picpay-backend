package br.com.banco.core.exception;

public class TaxNumberException extends Exception{
    private String code;

    public TaxNumberException(String code, String message) {
        super(message);
        this.code = code;
    }
}
