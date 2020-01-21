package com.acme.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class MyService {

    @RestClient
    MyClient myClient;

    @Inject
    MyClientOptions myClientOptions;

    public ServerResponse get() {
        return myClient.get(myClientOptions);
    }

}
