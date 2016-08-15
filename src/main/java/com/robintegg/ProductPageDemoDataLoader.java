package com.robintegg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.robintegg.account.Customer;
import com.robintegg.account.CustomerID;
import com.robintegg.account.CustomerRepository;
import com.robintegg.account.HomeLocation;
import com.robintegg.sales.Category;
import com.robintegg.sales.SalesLocation;
import com.robintegg.sales.Product;
import com.robintegg.sales.ProductRepository;

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

		String londonLocationID = "LONDON";
		String liverpoolLocationID = "LIVERPOOL";

		// location value objects
		SalesLocation LIVERPOOL = new SalesLocation(liverpoolLocationID);
		SalesLocation LONDON = new SalesLocation(londonLocationID);

		// load products
		this.productRepository.save(new Product("Arsenal TV", Category.SPORTS, LONDON));
		this.productRepository.save(new Product("Chelsea TV", Category.SPORTS, LONDON));
		this.productRepository.save(new Product("Liverpool TV", Category.SPORTS, LIVERPOOL));
		this.productRepository.save(new Product("Sky News", Category.NEWS, SalesLocation.ANY_LOCATION));
		this.productRepository.save(new Product("Sky Sport News", Category.NEWS, SalesLocation.ANY_LOCATION));

		// load customers
		this.customerRepository.save(new Customer(new CustomerID("robin"), new HomeLocation(londonLocationID)));
		this.customerRepository.save(new Customer(new CustomerID("dan"), new HomeLocation(liverpoolLocationID)));
		this.customerRepository.save(new Customer(new CustomerID("alex")));

	}

}
