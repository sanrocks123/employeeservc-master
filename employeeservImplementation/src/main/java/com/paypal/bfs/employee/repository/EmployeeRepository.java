package com.paypal.bfs.employee.repository;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Java Source EmployeeRepository.java created on Jun 19, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface EmployeeRepository {

    /**
     * @param employee
     * @return
     */
    public Employee createEmployee(Employee employee);

    /**
     *
     * @param id
     * @return
     */
    public Employee getEmployeeById(String id);

}
