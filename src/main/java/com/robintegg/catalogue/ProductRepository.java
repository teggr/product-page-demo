package com.robintegg.catalogue;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robintegg.location.Location;

public interface ProductRepository extends JpaRepository<Product, String> {

	Collection<Product> findByLocationIn(Collection<Location> locations);

}
