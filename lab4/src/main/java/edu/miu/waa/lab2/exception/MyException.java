package edu.miu.waa.lab2.exception;

public class MyException extends Exception {
    private final String msg;

    public MyException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
