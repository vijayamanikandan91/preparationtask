package com.myapp.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	@Query(value="select * from employees_details where salary>=?", nativeQuery = true)
	public List<Employee> getEmployeeBySalary(int salary);
	
	@Query(value="select * from employees_details where name like %?", nativeQuery = true)
	public List<Employee> getEmployeeByname(String name);
	
	@Query(value="select max(salary) from "
			+ "employees_details", nativeQuery=true)
	public int getMaxSal();
	
	@Query(value="select * from employees_details where salary = (select max(salary) from employees_details)", nativeQuery = true)
	public Employee getMaxEmp();

}

