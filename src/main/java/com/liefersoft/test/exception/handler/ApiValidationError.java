package com.liefersoft.test.exception.handler;

import java.util.List;
import java.util.Objects;


class ApiValidationError {
    private List<Object> object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(List<Object> object, String message) {
        this.object = object;
        this.message = message;
    }

    public List<Object> getObject() {
        return object;
    }

    public void setObject(List<Object> object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiValidationError)) return false;
        ApiValidationError that = (ApiValidationError) o;
        return Objects.equals(object, that.object) && Objects.equals(field, that.field) && Objects.equals(rejectedValue, that.rejectedValue) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, field, rejectedValue, message);
    }
}
