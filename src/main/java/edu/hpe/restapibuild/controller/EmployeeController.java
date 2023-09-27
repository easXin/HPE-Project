package edu.hpe.restapibuild.controller;

import edu.hpe.restapibuild.business.EmployeeService;
import edu.hpe.restapibuild.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public Map<String,List<Employee>> getEmpList(){
        Map<String,List<Employee>> res = new HashMap<>();
        List<Employee> empList = service.getEmpList();
        res.put("Employees",empList);
        return res;
    }

    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        service.addEmp(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployee_id())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
