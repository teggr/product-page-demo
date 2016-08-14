package com.robintegg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.robintegg.catalogue.Category;
import com.robintegg.catalogue.Product;
import com.robintegg.catalogue.ProductRepository;
import com.robintegg.customer.Customer;
import com.robintegg.customer.CustomerID;
import com.robintegg.customer.CustomerRepository;
import com.robintegg.location.Location;

@Component
public class ProductPageDemoDataLoader implements ApplicationRunner {

	private ProductRepository productRepository;
	private CustomerRepository customerRepository;

	@Autowired
	public ProductPageDemoDataLoader(ProductRepository productRepository, CustomerRepository customerRepository) {
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// location value objects
		Location LIVERPOOL = new Location("LIVERPOOL");
		Location LONDON = new Location("LONDON");

		// load products
		this.productRepository.save(new Product("Arsenal TV", Category.SPORTS, LONDON));
		this.productRepository.save(new Product("Chelsea TV", Category.SPORTS, LONDON));
		this.productRepository.save(new Product("Liverpool TV", Category.SPORTS, LIVERPOOL));
		this.productRepository.save(new Product("Sky News", Category.NEWS, Location.ANY_LOCATION));
		this.productRepository.save(new Product("Sky Sport News", Category.NEWS, Location.ANY_LOCATION));

		// load customers
		this.customerRepository.save(new Customer(new CustomerID("robin"), LONDON));
		this.customerRepository.save(new Customer(new CustomerID("dan"), LIVERPOOL));

	}

}
