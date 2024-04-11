package br.com.banco.core.exception.enums;

public enum ErrorCodeEnum {

    // User
    ON0001("Tax number invalid", "ON-0001"),
    ON0002("Tax number unavailable", "ON-0002"),
    ON0003("Email unavailable", "ON-00003"),
    ON0004("Error while creating user", "ON-00004"),

    // Transaction
    TR0001("Shopkeeper user cannot make a transfer", "TR-0001"),
    TR0002("Unavailable balance", "TR-0002"),
    TR0003("Error when performing the transfer", "TR-0003"),
    TR0004("Unauthorized transfer", "TR-0004"),

    // Pin creating
    TP0001("The pin must have 8 digits", "TP-0001"),

    // Pin
    PIN0001("The transaction pin is blocked", "PIN-0001"),
    PIN0002("Incorrect Pin, %d remaining attempts", "PIN-0002"),

    // Wallet
    WT0001("Wallet not found", "WT-0001"),

    // Notification
    NF0001("There was an error notifying the user", "NF-0001"),

    // Authentication
    AUTH0001("Authentication failed", "AUTH-0001"),

    // Consult Balance
    CB0001("Error when checking balance", "CB-0001"),

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

    public static String pinGetMessage(Integer attempt) {
        return String.format(PIN0002.message, attempt);
    }
}
