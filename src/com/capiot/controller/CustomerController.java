package com.capiot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capiot.dao.CustomerDAO;
import com.capiot.entity.Customer;
import com.capiot.entity.Ticket;
import com.capiot.entity.Wallet;
import com.capiot.qrcodegenerator.QrCodeGenerator;

@Controller
@RequestMapping("/customer")

public class CustomerController {

	//Injecting CustomerDAO dependency
	@Autowired
	private CustomerDAO customerDao;
	
	@GetMapping("/register")
	public String registerCustomer(Model theModel) {
		
		//Create Form Object
		Customer theCustomer = new Customer();	
		//Attaches Customer info to model attribute
		theModel.addAttribute("customer",theCustomer);
		//Show Customer Form
		return "customer-registration-form";
	}
	
	@GetMapping("/getCustomer/{customerId}")
	public String getCustomer(@PathVariable("customerId") int id, Model theModel){
		System.out.println("\nCustomer Id : " + id);
		Customer customer = customerDao.getCustomer(id);
		System.out.println("Customer in Controller : " + customer);
		theModel.addAttribute("customer", customer);
		return "customer-info";
	}	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers = customerDao.getCustomers();
		for(Customer customer : theCustomers) {
			System.out.println(customer);
		}
		theModel.addAttribute("customers",theCustomers);
		return "list-customer";
	}
	
	
	@GetMapping("/getWallet")
	public String getWallet(@RequestParam("customerId") int theId,Model theModel){
		
		System.out.println("\n\n\n---------------------Get Wallet-------------------\n");
		System.out.println("Customer Id : " + theId);		
		Customer customer = customerDao.getCustomer(theId);
		Wallet wallet = new Wallet();
		wallet = customer.getWallet();
		System.out.println("Wallet Info :" + wallet.toString());
		theModel.addAttribute("customer",customer);
		System.out.println("\n\n\n---------------------Model Attribute added-------------------\n");
		return "get-wallet-info";
	
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		System.out.println("Customer Info : " + theCustomer.toString());
		System.out.println("Saving Customer....");
		customerDao.saveCustomer(theCustomer);
		
		System.out.println("Customer Object saved\n");
		return "customer-info";
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomerWallet(@ModelAttribute("customer") Customer theCustomer) {
		
		System.out.println("Customer Info : " + theCustomer.toString());
		System.out.println("Saving Customer....");
		customerDao.updateCustomer(theCustomer);
		
		System.out.println("Customer Object saved\n");
		return "customer-info";
	}

	@GetMapping("/generateTicket")
	public void generateTicket() throws IOException{
		QrCodeGenerator qrCodeGenerator = new QrCodeGenerator();
		qrCodeGenerator.saveImage("http://api.qrserver.com/v1/create-qr-code/?data=HelloWorld!&size=200x200","qrCode.jpg");
	}
	
	
}










