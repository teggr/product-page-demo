package com.robintegg.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.customer.CustomerID;
import com.robintegg.customer.CustomerRepository;

@Service
public class CustomerLocationServiceImpl implements CustomerLocationService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerLocationServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Location getLocationForCustomer(CustomerID customerID) {
		return customerRepository.findOne(customerID).getHomeLocation();
	}

}
