package org.example.server;


import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8889/ws/person", new PersonServiceImpl());

    }
}