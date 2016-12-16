package com.evoke.researchlabs.row.employee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.researchlabs.row.employee.exception.AppException;
import com.evoke.researchlabs.row.employee.model.Employee;
import com.evoke.researchlabs.row.employee.model.InterestList;
import com.evoke.researchlabs.row.employee.service.EmployeeService;


/**
 * 
 * 
 * RestServiceController class which implements the
 * functionality to save data in MongoDB
 * @author P A VISHAL
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	@Autowired(required=true)
	EmployeeService employeeService;
	

	/**
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		Employee result = null;
		logger.info("/POST request, inside create method ");
		try {

			result = employeeService.saveEmployee(employee);
System.out.println("employ get id value is ::::::::::"+employee.getId());
			logger.debug("suceessfully data saved in PostgresDB" + result);
			if (result == null)
				throw new AppException("Exception while saving data in PostgresDB");
		} catch (AppException e) {
			logger.debug("exception occurred while saving data in PostgresDB", e);
		}
		logger.info("returned result value is " + result);
		return result;
	}

	/**
	 * @return
	 */
	
	@RequestMapping(value="/listEmployees", method=RequestMethod.GET)
	public Iterable<Employee> findAllEmployee() {
		
		Iterable<Employee> list=null;
		logger.info("/GET request, inside findAllEmployee method ");
		try{
		list =  employeeService.listAllEmployees();
		
		if(list == null)
			throw new AppException("exception occurred while receiving data from Postgres");
		}catch(AppException e)
		{
			logger.debug("exception occurred while saving data in PostgresDB", e);	
		}
		//List<Employee>listEmp= (List) Lists.newArrayList(list);
		logger.info("returned result value is " + list);
		return list;
	}
	
	
	@RequestMapping(value="employeeById/{id}", method=RequestMethod.GET)
	public Employee getObjectById(@PathVariable Integer id)
	{
		return employeeService.getObjectById(id);
		
		
	}
	
	@RequestMapping(value="deleteById/{id}", method=RequestMethod.GET)
	public void deleteObjectById(@PathVariable Integer id)
	{
		employeeService.deleteObjectById(id);
		
	}
	
	
	
}
