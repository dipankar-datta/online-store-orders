package com.dipankar.onlinestore.orders.util.exception;

public enum ExceptionType {
    USER_NOT_FOUND("User not found"),
    NO_DATA_FOUND("No data found"),
    ROLE_NOT_FOUND("Role not found"),
    CREDENTIAL_NOT_FOUND("Credential not found"),
    INVALID_REQUEST("Invalid request"),
    INVALID_LOGIN("Invalid login");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
