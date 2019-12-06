package com.javainuse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Address;
import com.javainuse.model.Employee;
import com.javainuse.model.Person;
import com.javainuse.model.Product;
import com.javainuse.service.PersonService;
import com.javainuse.service.RabbitMQSender;

@RestController
@RequestMapping("/javainuse")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	Address address;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}
	
	@GetMapping("/person")
	public List<Person> getPerson(@RequestParam("city") String city,@RequestParam("zip") String zip){
		address.setCity(city);	
		address.setZip(zip);
		System.out.println("city::   "+city);
		return (List<Person>) personService.getPersonByAddress(address);
		
	}

}

