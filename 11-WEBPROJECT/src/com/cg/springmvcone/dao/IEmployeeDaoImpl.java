package com.cg.springmvcone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcone.dto.Employee;

@Repository("employeedao")
public class IEmployeeDaoImpl implements IEmployeeDao {
	@PersistenceContext
	EntityManager entityManger;

	@Override
	public int addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub

		entityManger.persist(emp);
		entityManger.flush();
		return emp.getEmpId();
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		Query queryOne = entityManger.createQuery("FROM Employee");
		List<Employee> myList = queryOne.getResultList();

		return myList;
	}

	@Override
	public void deleteEmployee(int empId) {
		Query queryTwo = entityManger
				.createQuery("DELETE FROM Employee WHERE empId=:eid");
		queryTwo.setParameter("eid", empId);
		queryTwo.executeUpdate();

	}

	@Override
	public boolean updateEmployee(Employee emp) {
		boolean result=false;
		int id=emp.getEmpId();
		
		/*Employee employee = entityManger.find(Employee.class,id);*/
		entityManger.merge(emp);
		
		result=true;
		return result;
	}

	@Override
	public Employee searching(int id) {

		/*
		 * Query queryThree = entityManger
		 * .createQuery("SELECT FROM Employee WHERE id=:eid");
		 * queryThree.setParameter("eid",id);
		 */
		Employee employee = entityManger.find(Employee.class, id);
		return employee;
	}

}
