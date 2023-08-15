package com.myapp.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) throws AgeException {
		try {
			if (e.getAge() < 18 || e.getAge() > 35) {
				throw new AgeException("Age is under 18");
			} else {
				return empDao.addEmployee(e);
			}

			// return empDao.addEmployee(e);
		} catch (AgeException ae) {
			return "wrong age Input";
		}

	}

	public Employee getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	public String addEmps(List<Employee> emps) {
		return empDao.addEmps(emps);
	}

	public List<Employee> getAllEmp() {
		return empDao.getAllEmp();
	}

	public String deleteObj(int id) {
		return empDao.deleteObj(id);
	}

	public String updateObj(Employee e) {
		return empDao.updateObj(e);
	}

	public String deleteAl() {
		return empDao.deleteAl();
	}

	public List<Employee> getEmpbyname(String name) throws NameNotFoundException {
		List<Employee> allEmp = empDao.getAllEmp();
		List<Employee> emp = allEmp.stream().filter(x -> x.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		;
		if (emp.isEmpty()) {
			throw new NameNotFoundException("Invalid name");
		} else {

			return emp;
		}
	}

	public List<Employee> getSalaryIncrease() {
		List<Employee> emp = empDao.getAllEmp();
		return emp.stream().map(x -> {
			if (x.getAge() > 20 && x.getAge() < 25) {
				x.setSalary(x.getSalary() + 5000);
			}
			if (x.getAge() > 25 && x.getAge() < 30) {
				x.setSalary(x.getSalary() + 6000);
			}
			if (x.getAge() > 30 && x.getAge() < 40) {
				x.setSalary(x.getSalary() + 7000);
			}

			return x;
		}).toList();
	}

	public List<Employee> getEmpbyAge(int age) throws AgeNotAvailableException {
		
		List<Employee> emp = empDao.getAllEmp();
		List<Employee> emp1 =  emp.stream().filter(x -> x.getAge() == age).collect(Collectors.toList());
		if(emp1.isEmpty()) {
			throw new AgeNotAvailableException("invalid age");
		} else {
		return emp1;
	}
	}

	public List<Employee> getEmpGender(String gender) {
		List<Employee> emp = empDao.getAllEmp();
		return emp.stream().filter(x -> x.getGender().equalsIgnoreCase(gender)).toList();
	}

	public List<Employee> getEmployeeBySalary(int salary) {
		return empDao.getEmployeeBySalary(salary);
	}

	public List<Employee> getEmployeeByname(String name) {
		return empDao.getEmployeeByname(name);
	}

	public int getMaxSal() {
		return empDao.getMaxSal();
	}

	public Employee getMaxEmp() {
		return empDao.getMaxEmp();
	}
	
	public String updateName() {
		List<Employee> em = empDao.getAllEmp();
		em.stream().map(x->{
			if(x.getName().equals("devi")) {
				x.setName("radhika");
			} 
			return x;
		}).toList();
	
		
		return "sucessfully updated";
		
	}

}
