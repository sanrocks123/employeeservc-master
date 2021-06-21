package com.paypal.bfs.employee.exception;

import org.springframework.http.HttpStatus;

/**
 * Java Source EmployeeCommonBaseException.java created on Jun 19, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class EmployeeCommonBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus status;

    /**
     *
     */
    public EmployeeCommonBaseException(String errorCode, String errorMessage, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

}
