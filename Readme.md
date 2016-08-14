# Product Selection Page Demo

## Registered Customers for customerID cookie values

* Robin - LONDON
* Dan - LIVERPOOL

See below for setting cookie manually

## Running the application

### Using Maven

	mvn spring-boot:run

or 

	mvn clean package
	cd target
	java -jar product-page.jar

### Opening the product page

Open browser on http://localhost:8080

* Note, that you will require a cookie on this page with a customerID from above. To add this cookie manually, see below:

#### Add a cookie manually (chrome)

You can go to the Developer Tools (Ctrl-Shift-J or Tools -> Developer Tools) -> Console and the you can enter javascript command:

	document.cookie="customerID=robin"