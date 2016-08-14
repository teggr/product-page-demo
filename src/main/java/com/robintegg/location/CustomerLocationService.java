package com.robintegg.location;

import com.robintegg.customer.CustomerID;

public interface CustomerLocationService {

	Location getLocationForCustomer(CustomerID customerID);

}
