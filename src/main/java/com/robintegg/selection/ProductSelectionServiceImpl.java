package com.robintegg.selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.catalogue.Catalogue;
import com.robintegg.catalogue.CatalogueService;
import com.robintegg.customer.CustomerID;
import com.robintegg.location.CustomerLocationService;
import com.robintegg.location.Location;

@Service
public class ProductSelectionServiceImpl implements ProductSelectionService {

	private CustomerLocationService locationService;
	private CatalogueService catalogueService;

	@Autowired
	public ProductSelectionServiceImpl(CustomerLocationService locationService, CatalogueService catalogueService) {
		this.locationService = locationService;
		this.catalogueService = catalogueService;
	}

	@Override
	public Catalogue getAvailableProductsCatalogue(CustomerID customerID) {

		Location location = locationService.getLocationForCustomer(customerID);

		return catalogueService.getCatalogueForLocation(location);

	}

}
