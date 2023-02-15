# Readme for Shopping Cart Microservice
Welcome to the readme for the Shopping Cart Microservice made with Spring Boot! This microservice is designed to handle shopping cart functionality for an e-commerce website. The service is packaged as a Docker container, and can be launched by running a Docker Compose file.

## Starting :
To get started with the microservice, follow these steps:

* Install Docker on your machine if you haven't already.
* Clone the repository from GitHub.
* Navigate to the root directory of the repository.
* Launch the Docker container by running the following command: `docker compose up`.
* Once the container is running, you can access the service at `http://localhost:8082`.

## Usage:
The service has several endpoints to handle shopping cart functionality:

* /api/v1/cart: Use a `POST` request to create a new empty cart. The endpoint returns the ID of the newly created cart.
* /api/v1/cart/{cartId}: Use a `GET` request to get the items in the cart with the given cart ID.
* /api/v1/cart/{cartId}: Use a `POST` request with a product ID and quantity to add the product to the cart with the given cart ID.
* /api/v1/cart/{cartId}/{productId}: Use a `DELETE` request to remove the product with the given ID from the cart with the given cart ID.
