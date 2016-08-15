package com.robintegg.account;

import org.junit.Test;

public class HomeLocationTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireALocationID() {
		new HomeLocation(null);
	}

}
