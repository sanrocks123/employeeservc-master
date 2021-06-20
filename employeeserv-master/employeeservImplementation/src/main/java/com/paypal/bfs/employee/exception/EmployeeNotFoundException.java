package com.paypal.bfs.employee.exception;

import org.springframework.http.HttpStatus;

/**
 * Java Source EmployeeNotFoundException.java created on Jun 19, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class EmployeeNotFoundException extends EmployeeCommonBaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param string
     * @param notFound
     */
    public EmployeeNotFoundException(String errorCode, String errorMessage, HttpStatus status) {
        super(errorCode, errorMessage, status);
    }

}
