package com.paypal.bfs.test.employeeserv.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Interface for employee resource operations.
 */
@RequestMapping(value = "/v1/bfs", produces = MediaType.APPLICATION_JSON_VALUE)
public interface EmployeeResource {

    /**
     *
     * @param employeee
     * @return
     */
    @PostMapping("/employee")
    ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employeee);

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id
     *            employee id.
     * @return {@link Employee} resource.
     */
    @GetMapping("/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

}
