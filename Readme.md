# Product Selection Page Demo

## Technical Choices

* Spring Boot for main Java application to provide web endpoints and data persistence
* JQuery and Mustache to provide lightweight dynamic content to products page
* Twitter Bootstrap for responsive grid and CSS framework
* BDD application

## Registered Customers for customerID cookie values

* robin - LONDON
* dan - LIVERPOOL
* dave - unknown customer

See below for setting cookie manually

## Running the application

### Requirements

* Java 8

### Github

Clone a copy of this repository

### Using Maven

From the project root directory

	mvn spring-boot:run

or if you don't have maven installed use the packaged maven command (windows ./mvnw.cmd, linux ./mvnw)

	mvnw.cmd spring-boot:run

### Opening the product page

Open browser on http://localhost:8080

* Note, that you will require a cookie on this page with a customerID from above. To add this cookie manually, see below:

#### Add a cookie manually (chrome)

You can go to the Developer Tools (Ctrl-Shift-J or Tools -> Developer Tools) -> Console and the you can enter javascript command:

	document.cookie="customerID=robin"
	
Refresh the page

## Testing results

During the test phase, the BDD framework will have captured the acceptance criteria report. This will be available at:

	{project_root}/target/jbehave/view/index.html