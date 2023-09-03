# Bank API

## Getting started

The port is specified into your `application.properties`, so the Bank API `baseUrl` should be `localhost:{{port}}`, for example `localhost:8080`

The envs for the database connection are also specified into this file.

use `mvn spring-boot:stop clean package spring-boot:start` to start or restart the server

## Local endpoints

1. `GET localhost:{{port}}/api/bank/v1/{{accountId}}/balance`
2. `GET localhost:{{port}}/api/bank/v1/{{accountId}}/transactions?fromAccountingDate={{fromAccountingDate}}&toAccountingDate={{toAccountingDate}}`
3. `POST localhost:{{port}}/api/bank/v1/{{accountId}}/money-transfers`

## Swagger
At `http://localhost:8080/swagger-ui/index.html#/` you can find the API documentation web page.

## Controllers
A controller is used to declare the endpoints and their interfaces, it's considered the entry point of an API and a documentation as
a code of the endpoints.

### error handling
Since this API is mapped 1:1 with the Fabrick API the responses body are the same or just slight edited, in order to keep all the useful returning errors from the Fabrick API. Status errors like "KO" and "500" are remapped to "502" because for this bank API consumer, these errors are not of the bank API itself. When an exception it's raised a 500 error is returned.

## Handlers
A handler is a class, called from a controller, where you can find the business logic and where you can use external services like databases and external APIs

## Services
A service is a class, called from a handler, used to call a particular external api

## Helpers
A helper is a class used to store reusable logic to use across the whole application

## Model
Used to create the database and to create an interface with it. For every table there is an entity class, used to declare
the schema of your table and a repository class, used to provide a set of functionality to access the data of your table.

## Dto
Classes used as types across the whole application. The requests and responses folders are intended as the requests and response bodies

## Testing
For every controller endpoint the idea is to test that the service method is called and the service response is then returned as the controller response.  