package br.com.banco.core.exception;

public class InternalServerError extends Exception{
    private String code;

    public InternalServerError(String code, String message) {
        super(message);
        this.code = code;
    }
}
