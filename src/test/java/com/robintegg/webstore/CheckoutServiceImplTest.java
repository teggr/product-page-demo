package com.robintegg.webstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.robintegg.account.CustomerID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CheckoutServiceImplTest {

	@Autowired
	CheckoutService service;

	@Transactional
	@Test
	public void shouldStartACheckout() {

		CustomerID customerID = new CustomerID("james");

		Checkout startCheckout = new Checkout(customerID, Arrays.asList("a", "b", "c"));
		service.startCheckout(startCheckout);

		Checkout checkoutInProgress = service.getCheckout(customerID);

		assertEquals(startCheckout.getCustomerID().getCustomerID(), checkoutInProgress.getCustomerID().getCustomerID());
		assertEquals(startCheckout.getProductIDs().size(), checkoutInProgress.getProductIDs().size());
		assertTrue(startCheckout.getProductIDs().containsAll(checkoutInProgress.getProductIDs()));

	}

	@Transactional
	@Test
	public void shouldAllowANewStartCheckoutToReplaceAnOldOne() {

		CustomerID customerID = new CustomerID("tom");

		Checkout startCheckout1 = new Checkout(customerID, Arrays.asList("a", "b", "c"));
		service.startCheckout(startCheckout1);

		Checkout checkoutInProgress1 = service.getCheckout(customerID);

		assertEquals(startCheckout1.getCustomerID().getCustomerID(),
				checkoutInProgress1.getCustomerID().getCustomerID());
		assertEquals(startCheckout1.getProductIDs().size(), checkoutInProgress1.getProductIDs().size());
		assertTrue(startCheckout1.getProductIDs().containsAll(checkoutInProgress1.getProductIDs()));

		Checkout startCheckout2 = new Checkout(customerID, Arrays.asList("e", "f", "g"));
		service.startCheckout(startCheckout2);

		Checkout checkoutInProgress2 = service.getCheckout(customerID);

		assertEquals(startCheckout2.getCustomerID().getCustomerID(),
				checkoutInProgress2.getCustomerID().getCustomerID());
		assertEquals(startCheckout2.getProductIDs().size(), checkoutInProgress2.getProductIDs().size());
		assertTrue(startCheckout2.getProductIDs().containsAll(checkoutInProgress2.getProductIDs()));

	}

	@Transactional
	@Test
	public void shouldGetExistingCheckouts() {

		CustomerID customerID = new CustomerID("henry");

		Checkout startCheckout1 = new Checkout(customerID, Arrays.asList("a", "b", "c"));
		service.startCheckout(startCheckout1);

		Checkout checkoutInProgress1 = service.getCheckout(customerID);

		assertEquals(startCheckout1.getCustomerID().getCustomerID(),
				checkoutInProgress1.getCustomerID().getCustomerID());
		assertEquals(startCheckout1.getProductIDs().size(), checkoutInProgress1.getProductIDs().size());
		assertTrue(startCheckout1.getProductIDs().containsAll(checkoutInProgress1.getProductIDs()));

	}

	@Transactional
	@Test
	public void shouldReturnNoCheckoutIfNoneForCustomerID() {

		CustomerID customerID = new CustomerID("paul");

		Checkout checkout = service.getCheckout(customerID);

		assertNull(checkout);

	}

	@Transactional
	@Test
	public void shouldRemoveACheckoutOnCancel() throws NoCurrentCheckoutException {

		CustomerID customerID = new CustomerID("richard");

		Checkout startCheckout1 = new Checkout(customerID, Arrays.asList("a", "b", "c"));
		service.startCheckout(startCheckout1);

		assertNotNull(service.getCheckout(customerID));

		service.cancelCheckout(customerID);

		assertNull(service.getCheckout(customerID));

	}

	@Transactional
	@Test(expected = NoCurrentCheckoutException.class)
	public void shouldThrowExceptionIfCancellingNonExistentCheckout() throws NoCurrentCheckoutException {

		CustomerID customerID = new CustomerID("peter");

		assertNull(service.getCheckout(customerID));

		service.cancelCheckout(customerID);

	}

	@Transactional
	@Test
	public void shouldGetAConfirmationForACheckout() throws NoCurrentCheckoutException {

		CustomerID customerID = new CustomerID("jeff");

		Checkout startCheckout = new Checkout(customerID, Arrays.asList("a", "b", "c"));
		service.startCheckout(startCheckout);

		assertNotNull(service.getCheckout(customerID));

		Checkout checkout = service.getCheckout(customerID);

		assertEquals(startCheckout.getCustomerID().getCustomerID(), customerID.getCustomerID());
		assertTrue(startCheckout.getProductIDs().containsAll(checkout.getProductIDs()));
		assertEquals(startCheckout.getProductIDs().size(), checkout.getProductIDs().size());

	}

	@Transactional
	@Test(expected = NoCurrentCheckoutException.class)
	public void shouldThrowExceptionIfTryingToGetConfirmationForNonExistentCheckout()
			throws NoCurrentCheckoutException {

		CustomerID customerID = new CustomerID("thomas");

		assertNull(service.getCheckout(customerID));

		service.getConfirmation(customerID);

	}

}
