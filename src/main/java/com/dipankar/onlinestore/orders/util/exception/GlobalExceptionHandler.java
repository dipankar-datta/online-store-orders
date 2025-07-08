package com.dipankar.onlinestore.orders.util.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.dipankar.onlinestore.orders.util.exception.HttpsStatusExceptionMapping.statusMap;
import static java.time.LocalDateTime.now;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleApplicationException(ApplicationException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", now());
        body.put("status", statusMap.get(ex.getExceptionType()).value());
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, statusMap.get(ex.getExceptionType()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
        LocalDateTime localDateTime = now();
        log.error("Exception occurred with timestamp: {}",localDateTime, ex);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", localDateTime);
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("message", "Application Error. Please contact support for assistance.");
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
