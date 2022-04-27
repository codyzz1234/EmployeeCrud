package com.example.EmployeeInformation.EmpInfo.ExceptionHandling;

public class EmployeeFailedToSaveException extends Exception {
    public EmployeeFailedToSaveException() {
        super();
    }

    public EmployeeFailedToSaveException(String message) {
        super(message);
    }

    public EmployeeFailedToSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeFailedToSaveException(Throwable cause) {
        super(cause);
    }

    protected EmployeeFailedToSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
