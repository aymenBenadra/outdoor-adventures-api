# Product Service

The product service is responsible for managing product information. It is a Spring Boot application that uses Elasticsearch as its database. The service provides REST APIs for creating, updating, deleting, and retrieving product information.
Prerequisites

Before running the product service, make sure you have the following installed on your machine:

- Java 11 or higher
- Elasticsearch 7.x or higher

## Getting Started

To start the product service, first clone this repository:

```sh

git clone https://github.com/your-username/ecommerce-microservices.git
```

Then, navigate to the product service directory:

```sh

cd ecommerce-microservices/product-service
```

Next, build the project using Maven:

```sh

mvn clean install
```

Finally, start the product service using the following command:

```sh

java -jar target/product-service-0.0.1-SNAPSHOT.jar
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
    - quantity (required): The quantity of the product in stock.

`GET /products/{id}`

This endpoint returns the product with the specified ID.
`PUT /products/{id}`

This endpoint updates the product with the specified ID. The request body should contain a JSON object with the fields to be updated.
`DELETE /products/{id}`

This endpoint deletes the product with the specified ID.
Elasticsearch Configuration

The product service uses Elasticsearch to store product data. By default, the service connects to a locally running Elasticsearch instance on port 9200. If you need to connect to a different Elasticsearch instance, you can modify the spring.data.elasticsearch.cluster-nodes property in the application.properties file.
## Contributing

Feel free to contribute to this project by submitting a pull request.
## License

This project is licensed under the MIT License. See the LICENSE file for more information.
