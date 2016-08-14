package com.robintegg.sales;

import com.robintegg.common.Location;

/**
 * provides a service that offers channel subscriptions based on location
 * 
 * @author Sales Team
 *
 */
public interface CatalogueService {

	Catalogue getCatalogueForLocation(Location location);

}
