# eCommerce Microservices Application

This is an eCommerce application built using a microservices architecture, written in Java. The application consists of four services: customer service, cart service, product service, and order service.
Customer Service

## Getting started 

make sure you have git and docker installed in you system.

first clone the repo:

```bash
git clone https://github.com/sakamoto
```

### Customer Service

The customer service is responsible for managing customer information. It is a Spring Boot application that uses PostgreSQL as its database. The service provides REST APIs for creating, updating, deleting, and retrieving customer information.

To run the customer service, you will need to have PostgreSQL installed and configured. You will also need to set up the database schema using the SQL scripts provided in the sql folder.

To start the customer service, run the following command:

```bash

cd customer-service
docker compose up -d
```

### Cart Service

The cart service is responsible for managing shopping cart information. It is a Spring Boot application that uses Redis as its database. The service provides REST APIs for adding, removing, and retrieving items from the cart.

To run the cart service, you will need to have Redis installed and configured.

To start the cart service, run the following command:

```bash

cd cart-service
docker compose up -d
```

### Product Service

The product service is responsible for managing product information. It is a Spring Boot application that uses a MongoDB database. The service provides REST APIs for creating, updating, deleting, and retrieving product information.

To run the product service, you will need to have MongoDB installed and configured.

To start the product service, run the following command:

```bash

cd product-service
docker compose up -d
```

### Order Service

The order service is responsible for managing orders. It is a Spring Boot application that uses a MySQL database. The service provides REST APIs for creating, updating, deleting, and retrieving order information.

To run the order service, you will need to have MySQL installed and configured. You will also need to set up the database schema using the SQL scripts provided in the sql folder.

To start the order service, run the following command:

```bash

cd order-service
docker compose up -d
```


### Stock Service

The stock service is responsible for managing stock levels. It is a Spring Boot application that uses a PostgreSQL database. The service provides REST APIs for creating, updating, deleting, and retrieving stock information.

To run the stock service, you will need to have PostgreSQL installed and configured. You will also need to set up the database schema using the SQL scripts provided in the sql folder.

To start the stock service, run the following command:

```bash

cd stock-service
docker compose up -d 
```

## Contributing

Feel free to contribute to this project by submitting a pull request.
License

This project is licensed under the MIT License. See the LICENSE file for more information.
