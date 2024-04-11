package br.com.banco.core.exception;

public class PinException extends Exception{
    private String code;

    public PinException(String code, String message) {
        super(message);
        this.code = code;
    }
}
