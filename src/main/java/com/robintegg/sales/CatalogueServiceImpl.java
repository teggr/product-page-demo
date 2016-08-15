package com.robintegg.sales;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CatalogueServiceImpl implements CatalogueService {

	private ProductRepository productRepository;

	@Autowired
	public CatalogueServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Catalogue getCatalogueForLocation(SalesLocation location) {
		return new Catalogue(productRepository.findByLocationIn(filterLocations(location)));
	}

	private List<SalesLocation> filterLocations(SalesLocation location) {
		return Arrays.asList(location, SalesLocation.ANY_LOCATION).stream()
				.filter(l -> l != null).collect(Collectors.toList());
	}

}
