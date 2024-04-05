package br.com.banco.core.exception;

public class NotFound extends Exception{
    private String code;

    public NotFound(String code, String message) {
        super(message);
        this.code = code;
    }
}
