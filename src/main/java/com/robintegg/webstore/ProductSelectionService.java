package com.robintegg.webstore;

import com.robintegg.account.CustomerID;
import com.robintegg.account.UnknownCustomerException;
import com.robintegg.sales.Catalogue;

public interface ProductSelectionService {

	Catalogue getAvailableProductsCatalogue(CustomerID customerID) throws UnknownCustomerException;

}
