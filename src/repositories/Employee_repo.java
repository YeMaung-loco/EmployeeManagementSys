package repositories;

import java.util.List;

import Model.Employee;

public interface Employee_repo {
	List<Employee> findAllEmployees();
	//List<Employee> empList=findAllEmployees();
	
}
