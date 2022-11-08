package com.dream.universe.exception;

public class ChangePwdFailedException extends RuntimeException {
    public ChangePwdFailedException() {
        super();
    }
    public ChangePwdFailedException(String s) {
        super(s);
    }
    public ChangePwdFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangePwdFailedException(Throwable cause) {
        super(cause);
    }
}
