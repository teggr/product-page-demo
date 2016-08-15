package com.robintegg.account;

/**
 * @author Account Team
 *
 */
public interface CustomerLocationService {

	HomeLocation getLocationForCustomer(CustomerID customerID) throws UnknownCustomerException;

}
