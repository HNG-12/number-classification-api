package com.hng.stageone.numberclassificationapi.model;

public class ErrorResponse {
    private String number;
    private boolean error;

    public ErrorResponse(String number, boolean error) {
        this.number = number;
        this.error = error;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) {
        this.number = number;
    }
    public boolean isError() { return error; }
    public void setError(boolean error) {
        this.error = error;
    }
}
