package com.evoke.researchlabs.row.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evoke.researchlabs.row.employee.model.Employee;
import com.evoke.researchlabs.row.employee.model.InterestList;
import com.evoke.researchlabs.row.employee.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	
	@Autowired
	private EmployeeRepository employeeRespository;

	@Override
	public Iterable<Employee> listAllEmployees() {
		return employeeRespository.findAll();
	}
	@Override
	public Employee getId(Integer id) {
		return employeeRespository.findOne(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}
	
	public Employee getObjectById(Integer id){
		
		return employeeRespository.findOne(id);
	}
	
	public void deleteObjectById(Integer id){
		
		employeeRespository.delete(id);
	}
	
	@Override
	public InterestList getInterestList() {
		System.out.println("getInterstList");
	String arr[]={"java","php",".Net"};
	InterestList obj=new InterestList();
	obj.setInterestList(arr);
	return obj;
		
	}
	
}
