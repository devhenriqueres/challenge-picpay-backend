package br.com.banco.core.exception;

public class ConsultBalanceException extends Exception{
    private String code;

    public ConsultBalanceException(String code, String message) {
        super(message);
        this.code = code;
    }
}
