package com.myapp.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully added";
	}
	
	
	
	
	public Employee getEmployee(int id) {
		return empRepo.findById(id).get();
		
	}
	public String addEmps(List<Employee> emps) {
		empRepo.saveAll(emps);
		return "Successfully added";
	}
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}
	public String deleteObj(int id) {
		 empRepo.deleteById(id);
		 return "Successfully deleted";
	}
	
	public String updateObj(Employee e) {
		empRepo.save(e);	
		return "updated successfully";
	}
	public String deleteAl() {
		empRepo.deleteAll();
		return "Successfully deleted";
	}
	public List<Employee> getEmployeeBySalary(int salary){
		return empRepo.getEmployeeBySalary(salary);		
	}
	public List<Employee> getEmployeeByname(String name){
		return empRepo.getEmployeeByname(name);
	}
	public int getMaxSal() {
		return empRepo.getMaxSal();
	}
	public Employee getMaxEmp() {
		return empRepo.getMaxEmp();
	}

}
