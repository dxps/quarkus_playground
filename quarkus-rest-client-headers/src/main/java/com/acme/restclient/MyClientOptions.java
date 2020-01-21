package com.acme.restclient;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HeaderParam;


@ApplicationScoped
public class MyClientOptions {

    @ConfigProperty(name = "myclient.username")
    String username;

    @ConfigProperty(name = "myclient.password")
    String password;

    @HeaderParam("Authorization")
    String authorization = authorization();

    String authorization() {
        System.out.printf(">>> MyClientOptions > authorization > username:%s password:%s\n", username, password);
        return "abc";
    }

}
