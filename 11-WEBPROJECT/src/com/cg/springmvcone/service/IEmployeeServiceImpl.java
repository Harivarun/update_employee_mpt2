package com.cg.springmvcone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springmvcone.dao.IEmployeeDao;
import com.cg.springmvcone.dto.Employee;
@Service
@org.springframework.transaction.annotation.Transactional
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDao employeeDao;
	@Override
	public int addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployeeData(emp);
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.showAllEmployee();
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub

		employeeDao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		return  employeeDao.updateEmployee(emp);
	}

	@Override
	public Employee searching(int id) {
		// TODO Auto-generated method stub
		return employeeDao.searching(id);
	}

}
