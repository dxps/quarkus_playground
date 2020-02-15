# Quarkus Vert.x Events

This project uses events/messages related features of Vert.x's Event Bus in a Quarkus application.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

<br/>

## Running the application in dev mode

You can run your application in dev mode that enables live coding using either:
* `./mvnw quarkus:dev`
* `./run-dev.sh`

<br/>

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `quarkus-vertx-events-1.0.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-vertx-events-1.0.0-SNAPSHOT-runner.jar`.

<br/>

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/quarkus-vertx-events-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .