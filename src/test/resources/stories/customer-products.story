Display customer’s available products

Narrative:
In order to trial the new location dependent channels
As a customer
I want to select the products that are available to me, based on the location of my home.

Scenario: Show product items based on location
Given a customer robin 
When robin goes to the product selection page
Then robin should see LONDON programmes and all NEWS programs

Scenario: Show error if not a customer

Scenario: Show error if a customer without a registered location


