package com.dipankar.onlinestore.orders.util.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

import static java.util.Map.entry;

public interface HttpsStatusExceptionMapping {

    Map<ExceptionType, HttpStatus> statusMap = Map.ofEntries(
            entry(ExceptionType.NO_DATA_FOUND, HttpStatus.NO_CONTENT),
            entry(ExceptionType.USER_NOT_FOUND, HttpStatus.BAD_REQUEST),
            entry(ExceptionType.INVALID_REQUEST, HttpStatus.BAD_REQUEST),
            entry(ExceptionType.CREDENTIAL_NOT_FOUND, HttpStatus.BAD_REQUEST),
            entry(ExceptionType.ROLE_NOT_FOUND, HttpStatus.BAD_REQUEST),
            entry(ExceptionType.INVALID_LOGIN, HttpStatus.BAD_REQUEST)
    );
}
