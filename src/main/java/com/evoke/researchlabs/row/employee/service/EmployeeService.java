package com.evoke.researchlabs.row.employee.service;

import com.evoke.researchlabs.row.employee.model.Employee;
import com.evoke.researchlabs.row.employee.model.InterestList;

public interface EmployeeService {

	
	
Iterable<Employee>	listAllEmployees();
InterestList getInterestList();
Employee saveEmployee(Employee employee);
Employee getId(Integer id);
Employee getObjectById(Integer id);
void deleteObjectById(Integer id);
	
	
}
