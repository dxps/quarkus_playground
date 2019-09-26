package org.devisions.quarkus.hello;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class HelloService {

    public String hello() {
        return "Hello!\n";
    }

    public String hello(String name) {
        return "Hello " + name + "!\n";
    }

    // Async examples

    public CompletionStage<String> helloAsync() {
        return CompletableFuture.supplyAsync(() -> "Hello!\n");
    }

    public CompletionStage<String> helloAsync(String name) {
        return CompletableFuture.supplyAsync(() -> "Hello " + name + "!\n");
    }


}
