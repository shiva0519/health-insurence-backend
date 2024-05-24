package com.healthinsurence.www.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurence.www.Entity.Payment;
import com.healthinsurence.www.Entity.Registration;
import com.healthinsurence.www.Service.RegisterService;
import com.healthinsurence.www.Service.paymentService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/payment")
public class paymentController {
	@Autowired
	paymentService paymentService;
	@Autowired
	RegisterService registerService;
//	
//	@PostMapping("/addCustomer/{email}")
//	public Payment addCustomer(@RequestBody Payment payment,@PathVariable(name="email") String email) {
//	
//		Registration register = new Registration();
//		register.setEmail(email);
//		return paymentservice.addCustomer(payment,register);
//	}
	@PostMapping("/addCustomer/{email}")
	public ResponseEntity<?> addCustomer(@RequestBody Payment payment, @PathVariable(name="email") String email) {
	    // Check if the user with the provided email exists in the registration table
	    Registration register = registerService.findByEmail(email);
	    if (register == null) {
	        return ResponseEntity.badRequest().body("User with email " + email + " not found");
	    }
	    
	    // Proceed with creating the payment record
	    Payment createdPayment = paymentService.addCustomer(payment, register);
	    return ResponseEntity.ok(createdPayment);
	}
	@GetMapping("/getCustomerDetails/{email}")
	public Payment getCustomer(@PathVariable String email) {
		return paymentService.getCustomer(email);
	}
	
	@GetMapping("/getCustomerDetailsByMail/{email}")
	public  List<Payment> getAllDetailsByMail(@PathVariable String email) {
		return paymentService.getCustomerByMail(email);
	}

}
