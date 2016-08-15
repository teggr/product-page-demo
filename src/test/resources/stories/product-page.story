Feature: As a customer, I want to select the products that are available to me, based on the location of my home.

Narrative:
In order to select the products that are available to me, based on the location of my home.
As a customer
I want to choose them on the web page

Scenario: Selecting products
Given the customer is on the product page
When the customer selects a product
Then the basket is updated to show the selected product

Scenario: Unselecting products
Given the customer is on the product page with a selected product
When the customer unselects a product
Then the basket is updated to be empty

Scenario: Confirmation page
Given the customer is on the product page with a selected product
When the customer chooses to checkout
Then the customer’s customerID and list of selected products are posted to the confirmation page
