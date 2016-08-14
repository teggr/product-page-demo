package com.robintegg.common;

import org.junit.Test;

public class LocationTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireALocationID() {
		new Location(null);
	}

}
