# hbb-market API

Welcome to the **hbb-market** API repository! This project is a simple e-commerce application developed using Spring Boot 3, Maven, Java 17, Docker, and Postgresql. Its objective is to be a full-stack project with Angular (planned for the future). Despite its simplicity, it features authentication, input validation, comprehensive testing, code quality, and documentation using Swagger.

## What is an API?

Imagine an API as the communication link between a restaurant and its customers. The restaurant, like your application, has all the resources and services to serve its customers, but it doesn't allow customers to enter the kitchen. Instead, customers interact with the restaurant through the waiter, who serves as an intermediary.

- **Waiter**: The waiter is similar to an API. It takes orders from the customers, relays them to the kitchen, and brings back the dishes. The waiter defines a set of rules or protocols (like a menu) that customers must follow when placing orders.

- **Restaurant Resources**: These are like the services and data your application provides. For example, the kitchen is where food is prepared, similar to how your application processes data.

- **Customers**: Customers represent external applications, users, or systems that want to interact with your application. They can't directly access the kitchen (resources) but can communicate with your application through the waiter (API).

In this project, the hbb-market API is the waiter that controls access to your e-commerce application's services and data. Customers (external applications or users) interact with your application by sending requests to the API, and the API processes those requests, just like a waiter taking orders and bringing food to customers at a restaurant.

## Checklist

Here is a checklist of what has been accomplished in this project:

### Product Domain:
- [x] Entity: The product data structure is defined as an entity.
- [x] Repository: Product data is stored and retrieved from the database.
- [x] Service: Business logic for products is implemented in a service.
- [x] Controller: RESTful API endpoints for products are created in a controller.
- [x] Exceptions: Custom exceptions for handling errors related to products are implemented.
- [x] Swagger Documentation: Comprehensive documentation for the API using Swagger.

### Docker & Postgres:

- [x] Connection with database by docker on docker-compose and using flyway for migrations

### Future Enhancements:

- [ ] Authentication: Implement user authentication and authorization for added security.
- [ ] Front End with Angular (Plus Point): Develop a front-end interface using Angular to provide a complete e-commerce experience.
- [ ] Unit tests
- [ ] Deploy