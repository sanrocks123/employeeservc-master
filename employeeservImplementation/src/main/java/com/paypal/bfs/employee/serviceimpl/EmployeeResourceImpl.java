package com.paypal.bfs.employee.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.employee.exception.EmployeeNotFoundException;
import com.paypal.bfs.employee.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Implementation class for employee resource.
 */

@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeRepository empRepo;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.paypal.bfs.test.employeeserv.api.EmployeeResource#createEmployee(com.
     * paypal.bfs.test.employeeserv.api.model.Employee)
     */
    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {

        final Optional<Employee> emp = Optional.ofNullable(empRepo.getEmployeeById(employee.getId().toString()));

        if (emp.isPresent()) {
            return new ResponseEntity<>(emp.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(empRepo.createEmployee(employee), HttpStatus.CREATED);
    }

    /**
     *
     */
    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        final Optional<Employee> emp = Optional.ofNullable(empRepo.getEmployeeById(id));

        if (!emp.isPresent()) {

            // we can also keep this errorCode, errorMessages in properties
            // files and resolve using locale resolver
            throw new EmployeeNotFoundException("emp.not.found", "Employee not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp.get(), HttpStatus.OK);
    }
}
