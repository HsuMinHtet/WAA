package edu.miu.waa.lab1.dto;

public class ErrorType {
    private String errorMessage;

    public ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
