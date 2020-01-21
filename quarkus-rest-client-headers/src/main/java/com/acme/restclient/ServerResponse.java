package com.acme.restclient;

public class ServerResponse {

    String response;

    @Override
    public String toString() {
        return String.format("ServerResponse{ response='%s' }", response);
    }

}
