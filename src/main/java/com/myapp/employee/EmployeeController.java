package com.myapp.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	static Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody Employee e) throws AgeException {
		return empSer.addEmployee(e);
	}

	@GetMapping(value = "/getemp/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empSer.getEmployee(id);
	}

	@PostMapping(value = "/addemps")
	public String addEmps(@RequestBody List<Employee> emps) {
		return empSer.addEmps(emps);

	}

	@GetMapping(value = "/getall")
	public List<Employee> getAllEmp() {
		PropertyConfigurator.configure("log.properties");
		log.info(empSer.getAllEmp());
		
		return empSer.getAllEmp();
	}

	@DeleteMapping(value = "/deleteobj/{id}")
	public String deleteObj(@PathVariable int id) {
		return empSer.deleteObj(id);
	}

	@PutMapping(value = "/updating")
	public String updateObj(@RequestBody Employee e) {
		return empSer.updateObj(e);
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAl() {
		return empSer.deleteAl();
	}

	@GetMapping(value = "/getEmpByName/{name}")
	public List<Employee> getEmpbyname(@PathVariable String name) throws NameNotFoundException {
		return empSer.getEmpbyname(name);
	}

	@PutMapping(value = "/salaryincrease")
	public List<Employee> getSalaryIncrease() {
		return empSer.getSalaryIncrease();
	}

	@GetMapping(value = "/getEmpbyage/{age}")
	public List<Employee> getEmpbyAge(@PathVariable int age) throws AgeNotAvailableException {
		return empSer.getEmpbyAge(age);
	}

	@GetMapping(value = "/getEmpbygender/{gender}")
	public List<Employee> getEmpGender(@PathVariable String gender) {
		return empSer.getEmpGender(gender);
	}

	@GetMapping(value = "/geteeem/{salary}")
	public List<Employee> getEmployeeBySalary(@PathVariable int salary) {
		return empSer.getEmployeeBySalary(salary);
	}

	@GetMapping(value = "/getempnam/{name}")
	public List<Employee> getEmployeeByname(@PathVariable String name) {
		return empSer.getEmployeeByname(name);
	}

	@GetMapping(value = "/getMax")
	public int getMaxSal() {
		return empSer.getMaxSal();
	}

	@GetMapping(value = "getMaxEmpDet")
	public Employee getMaxEmp() {
		return empSer.getMaxEmp();
	}

	RestTemplate rest = new RestTemplate();

	@GetMapping(value = "getcarviaemp")
	public List<Car> getCarViaEmp() {
		String url = "http://localhost:8081/cars/findallcars";
		ResponseEntity<List<Car>> response = rest.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Car>>() {});
		List<Car> cars = response.getBody();
		return cars;

	}
	@GetMapping(value="/getcarviaid/{id}")
	public Car getCarViaId(@PathVariable int id) {
		String url = "http://localhost:8081/cars/getCar/";
		ResponseEntity<Car> response = rest.exchange(url+id,HttpMethod.GET,null,Car.class);
		Car call = response.getBody();
		System.out.println(call);
		System.out.println("kgdskfrgrhdsjlkjfkds");
		return call;
		
	}
	@PutMapping(value="/updatingName")
	public String updateName() {
		return empSer.updateName();
	}
	
	
	
	
	
	
	
	
	

}
