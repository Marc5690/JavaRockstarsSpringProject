package com.example.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.onlinestore.model.Customer;
import com.example.onlinestore.model.CustomerRepository;

@RestController
public class ApplicationController {
	
	  @Autowired // Tells the application context to inject an instance of ProductRepository here. In this context, it seems
	  private CustomerRepository repository; //like you have to tell spring what you want in advance.
	
	  @RequestMapping("/")
	  @ResponseBody
	  public String index() {
		StringBuilder sb = new StringBuilder();
		sb.append("<title>Products</title><h1>Welcome to the product shop!</h1>");
		
		for(Customer cust : repository.findAll()) {
			sb.append(cust.getFirstName() + " " + cust.getLastName());
			sb.append("<br/>");
		}
		
		sb.append("<br/>");
		
		//Looks silly because it is. We may need some kind of JavaScript tech to get Springs UI working correctly.
		sb.append("please right-click and new tab <a href='localhost:8080/fileupload'>here</a> to upload files");
		
	    return sb.toString();
	  }

}
