package com.capiot.controller;

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
import com.capiot.dao.WalletDAO;
import com.capiot.entity.Customer;

@Controller
@RequestMapping("/customer")

public class CustomerController {

	//Injecting CustomerDAO dependency
	@Autowired
	private CustomerDAO customerDao;
	private WalletDAO walletDao;
	
	@GetMapping("/register")
	public String registerCustomer(Model theModel) {
		
		//Create Form Object
		Customer theCustomer = new Customer();	
		//Attaches Customer info to model attribute
		theModel.addAttribute("customer",theCustomer);
		//Show Customer Form
		return "customer-registration-form";
	}
	
	@GetMapping("/showCustomer/{customerId}")
	public String showCustomerLoginForm(@PathVariable("customerId") int id, Model theModel){
		System.out.println("\nCustomer Id : " + id);
		Customer customer = customerDao.getCustomer(id);
		System.out.println("Customer in Controller : " + customer);
		theModel.addAttribute("customer", customer);
		return "customer-info";
	}	
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		
		System.out.println("Customer Info : " + theCustomer.toString());
		System.out.println("Saving Customer....");
		customerDao.saveCustomer(theCustomer);
		
		System.out.println("Customer Object saved\n");
		return "customer-info";
	}
	

	@GetMapping("/updateWallet")
	public String updateWallet(@RequestParam("customerId") int theId,Model theModel){
		System.out.println("Customer Id : " + theId);
		Customer customer = customerDao.getCustomer(theId);
		customer.toString();
		System.out.println("Update Wallet!");
		return "update-wallet-info";
	}	
	
	
	
}









