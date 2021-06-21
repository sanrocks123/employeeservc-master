package com.paypal.bfs.employee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Java Source EmployeeExceptionAdvice.java created on Jun 19, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@ControllerAdvice
public class EmployeeExceptionAdvice {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     *
     * @return
     */
    @ExceptionHandler(value = EmployeeCommonBaseException.class)
    public ResponseEntity<EmployeeErrorResponseDTO> handleAppException(EmployeeCommonBaseException ex) {

        log.error("error: {}", ex);

        final EmployeeErrorResponseDTO response = new EmployeeErrorResponseDTO();
        response.setErrorCode(ex.getErrorCode());
        response.setErrorMessage(ex.getErrorMessage());
        response.setStatus(ex.getStatus());
        return new ResponseEntity<>(response, ex.getStatus());
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeErrorResponseDTO> handleAppException(MethodArgumentNotValidException ex) {

        log.error("error: {}", ex);

        final EmployeeErrorResponseDTO response = new EmployeeErrorResponseDTO();
        response.setErrorCode("400");
        response.setErrorMessage(ex.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmployeeErrorResponseDTO> handleException(Exception ex) {

        log.error("error: {}", ex);

        final EmployeeErrorResponseDTO response = new EmployeeErrorResponseDTO();
        response.setErrorCode("500");
        response.setErrorMessage(ex.getLocalizedMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
