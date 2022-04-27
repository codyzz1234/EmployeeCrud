package com.example.EmployeeInformation.EmpInfo.ExceptionHandling;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@ResponseStatus
public class RestEmployeeExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> EmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND,
                "Employee Not Found"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }

    @ExceptionHandler(EmployeeFailedToSaveException.class)
    public ResponseEntity<ErrorMessage> EmployeeFailedToSaveException(EmployeeFailedToSaveException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND,
                "Employee Failed To Be Added"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}
