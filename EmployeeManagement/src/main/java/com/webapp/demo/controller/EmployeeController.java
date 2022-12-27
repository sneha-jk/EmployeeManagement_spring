package com.webapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.EmployeeDao;
import com.webapp.demo.emp.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDao dao;
@RequestMapping("/addEmp")
@ResponseBody
public void addEmp(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String dept, Employee obj) {
	
	obj.setEmpId(id);
	obj.setEmpEmail(email);
	obj.setEmpName(name);
	obj.setDept(dept);
	dao.save(obj);
	System.out.println("employee has been added");
	
}

@RequestMapping("/delete")
@ResponseBody
public void deleteEmp(@RequestParam int id) {
	
	System.out.println("employee has been deleted");
	dao.deleteById(id);
	
}

@RequestMapping("/getAll")
@ResponseBody
public List<Employee> getAll() {
	
	return dao.findAll();
}

@RequestMapping("/getById")
@ResponseBody
public List<Employee> getById(@RequestParam int id) {
	System.out.println("emp by id");
	return dao.empById(id);
	
}

@RequestMapping("/deleteAll")
@ResponseBody
public void deletetAll() {
	
	 dao.deleteAll();
}


}