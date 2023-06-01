###### Shopping Cart Management System

This repository is an instance of a Spring Boot application and it uses H2 database to demonstrate use of database. Instead of H2 we can replace with the database config details.
It uses a standard design pattern. When a web request is received, it will pass through controller. From controller it moves to Service layer. This service layer would be responsible to further process it. It can/would be reponsible to connect to various utilities or repositories to fetch data from the repository.From this layer we also call mapper classes to convert into particular domain model or response model.

###### Current Scope:
1. User would be able to send list of items to calculate total cost of shopping basket.
2. It would be able to apply offers associated with the products. These offers are stored in database
3. Offers are limited to each product only. For eg, buy 3 apple at the cost of 2 or buy 2 limes at the cost of 1 (Buy 1 get 1 free)

###### Future Scope:
1. Add authorisation and authentication
2. Add a different table for Offers which can provide vast variety of offers
3. Apply coupon code or any discount at the total cost if any applicable
4. Remove items from the shopping list
5. Return/Refund damaged items
6. Change design to accommodate offers in a different approach -
7. Asd logger statements
8. Add validations for mandatory fields if any required
9. Add more custom exceptions if required and build more generic responses for exceptions

###### Assumptions:
1. You get only list of item names in the shopping bag

###### To run the code see below. You can of course also build and run the example in your IDE.

1. Build the code base mvn clean install
2. Run via Maven using Boot: mvn spring-boot:run

###### Once the API is running, it can be consumed:
GET: localhost:8095/calculateShoppingCost?items= - this is used to calculate total cost of the items in the bag after applying discount coupons related to each product

All tests will be executed as part of build but can also be run independently if need be.

