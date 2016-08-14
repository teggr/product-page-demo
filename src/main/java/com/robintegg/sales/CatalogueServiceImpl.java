package com.robintegg.sales;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.common.Location;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	private ProductRepository productRepository;

	@Autowired
	public CatalogueServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Catalogue getCatalogueForLocation(Location location) {
		return new Catalogue(productRepository.findByLocationIn(Arrays.asList(location, Location.ANY_LOCATION)));
	}

}
