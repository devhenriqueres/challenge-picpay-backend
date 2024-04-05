package br.com.banco.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax number invalid", "ON-0001"),

    TR0001("Shopkeeper user cannot make a transfer", "TR-0001"),
    TR0002("Unavailable balance", "TR-0002"),

    TP0001("The pin must have 8 digits", "TP-0001"),

    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
