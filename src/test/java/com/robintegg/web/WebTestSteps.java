package com.robintegg.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ui-test")
@Component
public class WebTestSteps {

	@Autowired
	Site site;

	@Given("the customer is on the product page")
	public void givenTheCustomerIsOnTheProductPage() {
		site.resetCustomerIDCookie("robin");
		ProductPage page = site.getProductPage().navigateTo();
		assertTrue(page.doesWelcomeMessageContain("robin"));
	}

	@When("the customer selects a product")
	public void whenTheCustomerSelectsAProduct() {
		ProductPage page = site.getProductPage();
		page.selectProduct("Chelsea TV");
	}

	@Then("the basket is updated to show the selected product")
	public void thenTheBasketIsUpdatedToShowTheSelectedProduct() {
		ProductPage page = site.getProductPage();
		assertTrue(page.isProductInBasket("Chelsea TV"));
		assertTrue(page.canCheckout());
	}

	@Given("the customer is on the product page with a selected product")
	public void givenTheCustomerIsOnTheProductPageWithASelectedProduct() {
		givenTheCustomerIsOnTheProductPage();
		whenTheCustomerSelectsAProduct();
	}

	@When("the customer unselects a product")
	public void whenTheCustomerUnselectsAProduct() {
		ProductPage page = site.getProductPage();
		page.unselectProduct("Chelsea TV");
	}

	@Then("the basket is updated to be empty")
	public void thenTheBasketIsUpdatedToBeEmpty() {
		ProductPage page = site.getProductPage();
		assertTrue(page.basketIsEmpty());
		assertFalse(page.canCheckout());
	}

	@When("the customer chooses to checkout")
	public void whenTheCustomerChoosesToCheckout() {
		ProductPage page = site.getProductPage();
		page.checkout();
	}

	@Then("the customer\u2019s customerID and list of selected products are posted to the confirmation page")
	public void thenTheCustomersCustomerIDAndListOfSelectedProductsArePostedToTheConfirmationPage() {
		ConfirmationPage confirmationPage = site.getConfirmationPage();
		assertTrue(confirmationPage.isCurrentPage());
		assertTrue(confirmationPage.isShowingProduct("Chelsea TV"));
	}

}
