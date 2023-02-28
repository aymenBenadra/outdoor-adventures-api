# Product Service

The product service is responsible for managing product information. It is a Spring Boot application that uses Elasticsearch as its database. The service provides REST APIs for creating, updating, deleting, and retrieving product information.
Prerequisites

Before running the product service, make sure you have the following installed on your machine:

- Java 11 or higher
- Elasticsearch 7.x or higher

## Getting Started

To start the product service, first clone this repository:

```sh
git clone https://github.com/IOU4/outdoor-adventures-api
```

Then, navigate to the product service directory:

```sh
cd outdoor-adventures-api/product-service
```


Finally, start the product service using the following command:

```sh

docker compose up -d
```

## API Endpoints

The product service provides the following API endpoints:

`GET /products`
This endpoint returns a list of all products.

`POST /products`
This endpoint creates a new product. The request body should contain a JSON object with the following fields:

- name (required): The name of the product.
- description: A description of the product.
- price (required): The price of the product.
- keywords : json array of keywords that are related to the product.

`GET /products/{id}`
This endpoint returns the product with the specified ID.

`PUT /products/{id}`
This endpoint updates the product with the specified ID. The request body should contain a JSON object with the fields to be updated.

`DELETE /products/{id}`

This endpoint deletes the product with the specified ID.

## Contributing

Feel free to contribute to this project by submitting a pull request.
## License

This project is licensed under the MIT License. See the LICENSE file for more information.
