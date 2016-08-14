package com.robintegg.webstore;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robintegg.account.CustomerID;

public interface CheckoutRepository extends JpaRepository<Checkout, CustomerID> {

}
