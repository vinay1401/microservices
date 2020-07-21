package springboot.jackson.example.controller;

import java.sql.Date;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import springboot.jackson.example.model.Customer;

@RequestMapping("/customer")
@Controller
public class CustomerController {

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") UUID customerId){
		
		return new ResponseEntity<Customer>(new Customer(UUID.randomUUID(),	"Test Customer", "Greater NOIDA", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveCustomer(@RequestBody Customer customer){
		System.out.println(customer);
	}
}
