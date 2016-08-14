Feature: As a customer, I want to select the products that are available to me, based on the location of my home.

Narrative:
In order to select the products that are available to me, based on the location of my home.
As a customer
I want to choose them on the web page

Scenario: Selecting products
Given the customer is on the product page
When the customer selects or unselects a product
Then the basket is updated to show the selected products.

Scenario: Checking out
Given the customer is on the product page
When the customer chooses to checkout
Then the customer is taken to the confirmation page.

Scenario: Confirmation page
Given the customer has a valid checkout
When the customer chooses to checkout
Then the customer’s customerID and list of selected products are posted to the confirmation page.
