package com.example.onlinestore;

import com.example.onlinestore.model.entities.Product;
import com.example.onlinestore.model.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// Persist some demo Products.
			repository.save(new Product("Shirt", new BigDecimal(20)));
			repository.save(new Product("Hat", new BigDecimal(15)));

			log.info("Product data setup complete.");
		};
	}

}
