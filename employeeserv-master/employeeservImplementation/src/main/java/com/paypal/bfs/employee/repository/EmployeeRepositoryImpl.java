package com.paypal.bfs.employee.repository;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.dizitart.no2.util.Iterables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private Nitrite db;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.paypal.bfs.employee.repository.EmployeeRepository#createEmployee(com.
     * paypal.bfs.test.employeeserv.api.model.Employee)
     */
    @Override
    public Employee createEmployee(Employee employee) {

        final ObjectRepository<Employee> repository = db.getRepository(Employee.class);
        final WriteResult wr = repository.insert(employee);

        final NitriteId nitriteId = Iterables.firstOrDefault(wr);
        log.info("createEmployee, nitriteId: {}", nitriteId);

        return repository.getById(nitriteId);
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
        final ObjectRepository<Employee> repository = db.getRepository(Employee.class);
        return repository.find(ObjectFilters.eq("id", Integer.valueOf(id))).firstOrDefault();
    }

}
