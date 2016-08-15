package com.robintegg.sales;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

	Collection<Product> findByLocationIn(Collection<SalesLocation> locations);

}
