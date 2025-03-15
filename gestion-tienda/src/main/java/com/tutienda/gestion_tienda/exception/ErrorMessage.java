package com.tutienda.gestion_tienda.exception;

import java.util.Date;

public class ErrorMessage {
    private Integer statusCode;
    private Date dateError;
    private String message;
    private String description;

    public ErrorMessage(Integer statusCode, Date dateError, String message, String description) {
        this.statusCode = statusCode;
        this.dateError = dateError;
        this.message = message;
        this.description = description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Date getDateError() {
        return dateError;
    }

    public void setDateError(Date dateError) {
        this.dateError = dateError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
