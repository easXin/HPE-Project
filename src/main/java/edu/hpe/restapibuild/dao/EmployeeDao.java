package edu.hpe.restapibuild.dao;

import edu.hpe.restapibuild.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployees();
    Employee addEmp(Employee emp);
}
