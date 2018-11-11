package com.example.onlinestore;

import com.example.onlinestore.fileio.StorageProperties;
import com.example.onlinestore.fileio.StorageService;
import com.example.onlinestore.model.Product;
import com.example.onlinestore.model.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
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
	
	 @Bean
	    CommandLineRunner init(StorageService storageService) {
	        return (args) -> {
	            storageService.deleteAll();
	            storageService.init();
	        };
	    }
	
}
