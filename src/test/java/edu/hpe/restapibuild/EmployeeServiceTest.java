package edu.hpe.restapibuild;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.hpe.restapibuild.business.EmployeeService;
import edu.hpe.restapibuild.dao.EmployeeDao;
import edu.hpe.restapibuild.dao.impl.EmployeeDaoImpl;
import edu.hpe.restapibuild.pojo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	@Mock
	private EmployeeDao dao;
	private EmployeeService employeeService;

	@BeforeEach
	public void setUp() {
		employeeService = new EmployeeService(dao); // Inject the mock dao into the service
	}

	@Test
	public void testGetEmpList() {
		// Create a list of employees
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("1", "Ashe", "He", "ashe.he@gmail.com", "SDE"));
		emps.add(new Employee("2", "Kerwin", "Wang", "kerwin.wang@gmail.com", "SDE"));
		emps.add(new Employee("3", "Jerry", "Shen", "jerry.shen@gmail.com", "QA"));

		// Mock the behavior of the dao to return the list when `getEmployees` is called
		when(dao.getEmployees()).thenReturn(emps);

		// Call the service method
		List<Employee> result = employeeService.getEmpList();

		// Verify that the dao's method was called
		verify(dao).getEmployees();

	}

	@Test
	public void testAddEmp() {
		Employee employee = new Employee("4", "Jonny", "Xie", "johnny.xie@gmail.com", "SDE");

		// Mock the behavior of the dao to do nothing when `addEmp` is called (if needed)
		when(dao.addEmp(employee)).thenReturn(null);

		// Call the service method
		employeeService.addEmp(employee);

		// Verify that the dao's method was called
		verify(dao).addEmp(employee);

	}
}
