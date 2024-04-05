package br.com.banco.core.exception;

public class TrasactionPinException extends Exception {

    private String code;

    public TrasactionPinException(String message, String code) {
        super(message);
        this.code = code;
    }
}
