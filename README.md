### Simple Spring Boot architecture using Commands and Queries

This project aims to showcase a simple architectural pattern for applications in which the simply three-tiered layer (Controller -> Service -> Repository) is no longer maintainable. You can find the full details on [Bluemagma's blog post](https://www.bluemagma.be/en/2021/12/simple-command-query-architecture-in-spring-boot/) about it.

### Run this project

Simply execute following command:

```
./mvnw spring-boot:run
```

Once it's running you can perform following actions:

* GetAllProductsQuery: `curl -v http://localhost:9010/product`
* GetProductByIdQuery: `curl -v http://localhost:9010/product/{productId}`
* AddProductCommand: `curl -v -X PUT http://localhost:9010/product -H "Content-Type: application/json" -d '{"name": "New Product", "unitPrice": "10.99", "description": "New Product description"}'`