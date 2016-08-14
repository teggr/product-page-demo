package com.robintegg.catalogue;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.robintegg.location.Location;

@Entity
public class Product {

	@Id
	private String productID;

	private String name;

	private Category category;

	@Embedded
	private Location location;

	Product() {
		// for JPA
	}

	public Product(String name, Category category, Location location) {
		this.productID = generateAProductID(name);
		this.name = name;
		this.category = category;
		this.location = location;
	}

	private String generateAProductID(String name) {
		return name.toLowerCase().replaceAll(" ", "_");
	}

	public String getProductID() {
		return productID;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public Location getLocation() {
		return location;
	}

	public boolean matchesCategory(Category category) {
		return this.category == category;
	}

}
