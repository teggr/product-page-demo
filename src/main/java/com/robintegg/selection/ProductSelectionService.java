package com.robintegg.selection;

import com.robintegg.catalogue.Catalogue;
import com.robintegg.customer.CustomerID;

public interface ProductSelectionService {

	Catalogue getAvailableProductsCatalogue(CustomerID customerID);

}
