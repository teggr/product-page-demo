package com.robintegg.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerLocationServiceImpl implements CustomerLocationService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerLocationServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public HomeLocation getLocationForCustomer(CustomerID customerID) throws UnknownCustomerException {
		Customer customer = customerRepository.findOne(customerID);
		if (customer == null) {
			throw new UnknownCustomerException();
		}
		return customer.getHomeLocation();
	}

}
