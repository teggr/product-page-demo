package com.robintegg.sales;

/**
 * provides a service that offers channel subscriptions based on location
 * 
 * @author Sales Team
 *
 */
public interface CatalogueService {

	Catalogue getCatalogueForLocation(SalesLocation location);

}
