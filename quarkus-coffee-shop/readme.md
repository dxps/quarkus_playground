## Quarkus Coffee Shop

A playground project for diving deeper into some of the features provided by Quarkus framework and ecosystem.

<br/>

### Usage

- Place an order:\
  `curl -X PUT localhost:8080/orders` -H 'content-type: application/json' -d '{ "type": "Cappuccino" }'
- Get all orders:\
  `curl localhost:8080/orders`

