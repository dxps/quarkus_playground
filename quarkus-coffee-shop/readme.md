## Quarkus Coffee Shop

A playground project for diving deeper into some of the features provided by Quarkus framework and ecosystem.

<br/>

### Setup & Run

As prerequisites and setup, you need:
- Have access to a PostgreSQL database.
  - You may use the provided `run-database.sh` script that starts a local PostgreSQL as a Docker container.
- Have Java SDK 21 installed.

Before starting up the service:
1. Verify the database credentials, if you use a different PostgreSQL than the one proposed before as container.
2. Run the database migration, to populate the database with the expected objects. 
   - Run `mvn liquibase:update`

Run the service using `mvn quarkus:dev`

<br/>

### Usage

- Get all orders:\
  `curl localhost:8080/orders`
- Get an order by id:\
  `curl localhost:8080/orders/uyt66u84HljQMsnWH891k`
- Place an order, of specific type of coffee:\
  - For a Cappuccino: `curl -X POST localhost:8080/orders -H 'content-type: application/json' -d '{ "type": "CAPPUCCINO" }'`
  - For an Expresso: `curl -X POST localhost:8080/orders -H 'content-type: application/json' -d '{ "type": "EXPRESSO" }'`

#### Examples

```shell
❯ curl -s localhost:8080/orders | jq
[
  {
    "id": "uyt66u84HljQMsnWH891k",
    "type": "expresso",
    "createdAt": "2024-01-22T18:24:28.726858Z"
  },
  {
    "id": "OAiJjcW5ZnF2pyAZkNaB1",
    "type": "cappuccino",
    "createdAt": "2024-01-22T18:24:57.321522Z"
  }
]
❯ 
```
