package nl.amis.rest;

import java.io.IOException;

import com.sun.net.httpserver.HttpServer;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App2 {
    private final static int port = 8765;
    private final static String host = "http://localhost/app";

    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri(host).port(port).build();
        ResourceConfig config = new ResourceConfig(Api.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
        System.out.println("HTTP Server is running and listening at "+baseUri+"/api" );
    }
}
