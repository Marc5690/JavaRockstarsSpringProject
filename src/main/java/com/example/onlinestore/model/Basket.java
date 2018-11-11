package com.example.onlinestore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Basket {

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id; 
	    
	    @OneToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customerOwner;
	    
	    @OneToMany(mappedBy = "basket")
	    private List<Product> products;

	    protected Basket() {}

	    public Basket(Customer customer) {
	    	this.customerOwner = customer;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	                "Basket[id=%d, customerFirstName='%s', customerLastName='%s']",
	                id, customerOwner.getFirstName(), customerOwner.getLastName());
	    }

		public Long getId() {
			return id;
		}
		
}
