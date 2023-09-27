package edu.hpe.restapibuild.business;

import edu.hpe.restapibuild.dao.EmployeeDao;
import edu.hpe.restapibuild.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDao dao;
    @Autowired
    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }


    public List<Employee> getEmpList(){
        List<Employee> empList = dao.getEmployees();
        return empList;
    }
    public void addEmp(Employee emp){
        dao.addEmp(emp);
    }
}
