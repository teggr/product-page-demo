package com.robintegg.sales;

import org.junit.Test;

public class LocationTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireALocationID() {
		new SalesLocation(null);
	}

}
