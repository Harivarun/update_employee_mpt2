package com.cg.springmvcone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvcone.dto.Employee;
import com.cg.springmvcone.service.IEmployeeService;

@Controller
public class MyController {
	@Autowired
	IEmployeeService employeeservice;
	@PersistenceContext
	EntityManager entityManger;

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public String getAll() {

		return "home";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute("my") Employee emp,
			Map<String, Object> model) {
		List<String> myDeg = new ArrayList<>();
		myDeg.add("SoftWare Engg");
		myDeg.add("Sr Consoltant");
		myDeg.add("Manager");
		model.put("deg", myDeg);
		return "addemployee";
	}

	@RequestMapping(value = "insertdata", method = RequestMethod.POST)
	public ModelAndView insertEmployee(
			@Valid @ModelAttribute("my") Employee emp, BindingResult result,
			Map<String, Object> model) {
		// System.out.println("Name is "+emp.getEmpName());
		int id = 0;
		if (result.hasErrors()) {
			List<String> myDeg = new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg", myDeg);
			return new ModelAndView("addemployee");
		} else {
			id = employeeservice.addEmployeeData(emp);
		}
		return new ModelAndView("sucess", "edata", emp);

	}

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public ModelAndView showAllEmployee() {
		List<Employee> myAllData = employeeservice.showAllEmployee();
		return new ModelAndView("showall", "temp", myAllData);
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteEmployee() {

		return "deleteemployee";

	}

	@RequestMapping(value = "dodelete", method = RequestMethod.GET)
	public String employeeDelete(@RequestParam("eid") int id) {
		// System.out.println("Id is ..."+id);
		employeeservice.deleteEmployee(id);
		return "sucess";

	}

	@RequestMapping(value = "search1", method = RequestMethod.GET)
	public String reqUpdate() {
		return "update1";
	}

	@RequestMapping(value = "update1", method = RequestMethod.GET)
	public ModelAndView employeeUpdate(@RequestParam("eid") int id) {

		Employee emp = employeeservice.searching(id);
		if (emp != null) {

			return new ModelAndView("updateEmployee", "edata", emp);

		} else {
			return new ModelAndView("noDataFound");
		}
	}

	@RequestMapping(value = "doupdate", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam("empId") int id,
			@ModelAttribute("my") Employee emp, Map<String, Object> model) {

		Employee emp1 = employeeservice.searching(id);
		if (emp1 != null) {
			List<String> myDeg = new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg", myDeg);
			return new ModelAndView("enterDetails", "emp", emp1);
		} else {
			return new ModelAndView("noDataFound");
		}
	}

	@RequestMapping(value = "insertdata1", method = RequestMethod.POST)
	public ModelAndView updateEmployee(
			@Valid @ModelAttribute("my") Employee emp, BindingResult result,
			Map<String, Object> model) {
		boolean result1;

		if (result.hasErrors()) {
			List<String> myDeg = new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg", myDeg);
			return new ModelAndView("enterDetails", "emp", emp);
		} else {
			result1 = employeeservice.updateEmployee(emp);
		}
		return new ModelAndView("sucess", "edata1", result1);
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchEmployee() {

		return "search";
	}

	@RequestMapping(value = "dosearch", method = RequestMethod.GET)
	public ModelAndView employeeSearch(@RequestParam("eid") int id) {
		// System.out.println("Id is ..."+id);
		Employee emp = employeeservice.searching(id);
		if (emp != null) {

			return new ModelAndView("showEmployee", "edata", emp);

		} else {
			return new ModelAndView("noDataFound");
		}
	}

}
