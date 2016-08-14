package com.robintegg.account;

import com.robintegg.common.Location;

/**
 * @author Account Team
 *
 */
public interface CustomerLocationService {

	Location getLocationForCustomer(CustomerID customerID) throws UnknownCustomerException;

}
