package com.robintegg.webstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robintegg.account.CustomerID;
import com.robintegg.account.CustomerLocationService;
import com.robintegg.account.UnknownCustomerException;
import com.robintegg.common.Location;
import com.robintegg.sales.Catalogue;
import com.robintegg.sales.CatalogueService;

@Transactional
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
	public Catalogue getAvailableProductsCatalogue(CustomerID customerID) throws UnknownCustomerException {

		Location location = locationService.getLocationForCustomer(customerID);

		return catalogueService.getCatalogueForLocation(location);

	}

}
