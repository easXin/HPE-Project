package edu.hpe.restapibuild.dao.impl;

import edu.hpe.restapibuild.dao.EmployeeDao;
import edu.hpe.restapibuild.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    static List<Employee> emps = new LinkedList<>();
    static{
        emps.add(new Employee("1","Ashe","He","ashe.he@gmail.com","SDE"));
        emps.add(new Employee("2","Kerwin","Wang","kerwin.wang@gmail.com","SDE"));
        emps.add(new Employee("3","Jerry","Shen","jerry.shen@gmail.com","QA"));
    }
    @Override
    public List<Employee> getEmployees() {
        return getEmps();
    }

    @Override
    public Employee addEmp(Employee emp) {
        emps.add(emp);
        return emp;
    }

    private List<Employee> getEmps(){
        return emps;
    }
}
