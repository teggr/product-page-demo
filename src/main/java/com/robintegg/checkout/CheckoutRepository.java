package com.robintegg.checkout;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robintegg.customer.CustomerID;

public interface CheckoutRepository extends JpaRepository<Checkout, CustomerID> {

}
