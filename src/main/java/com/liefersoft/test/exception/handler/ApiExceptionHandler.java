package com.liefersoft.test.exception.handler;

import com.liefersoft.test.exception.EntityNotExistsException;
import com.liefersoft.test.exception.PermissionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(err ->
                errorMap.put(err.getField(), err.getDefaultMessage()));
        return errorMap;
    }

    @ExceptionHandler(EntityNotExistsException.class)
    protected ResponseEntity<Object> handleEntityNotExists(
            EntityNotExistsException exception) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(PermissionException.class)
    protected ResponseEntity<Object> handlePermissionException(
            PermissionException exception) {
        return buildResponseEntity(HttpStatus.FORBIDDEN, exception.getMessage());
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus paymentRequired, String exception) {
        ApiError apiError = new ApiError(paymentRequired);
        apiError.setMessage(exception);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
