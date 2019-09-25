package org.devisions.quarkus.hello;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String hello(String name) {
        return "hello " + name + "\n";
    }

}
