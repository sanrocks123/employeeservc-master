package com.paypal.bfs.employee.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Java Source EmployeeRepositoryImpl.java created on Jun 19, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // temporary in memory cache for holding employee data
    private final Map<Integer, Employee> cache = new HashMap<>();

    /*
     * (non-Javadoc)
     *
     * @see
     * com.paypal.bfs.employee.repository.EmployeeRepository#createEmployee(com.
     * paypal.bfs.test.employeeserv.api.model.Employee)
     */
    @Override
    public Employee createEmployee(Employee employee) {
        cache.put(employee.getId(), employee);
        return employee;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.paypal.bfs.employee.repository.EmployeeRepository#getEmployeeById(
     * java.lang.String)
     */
    @Override
    public Employee getEmployeeById(String id) {
        return cache.get(Integer.valueOf(id));
    }

}
