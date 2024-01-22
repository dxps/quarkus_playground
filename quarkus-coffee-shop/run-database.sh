#!/bin/bash

docker run -d --name quarkus-coffee-shop \
    -p 5440:5432 \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    postgres:16.1

