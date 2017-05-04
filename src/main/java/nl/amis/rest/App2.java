package nl.amis.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;

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
        // multiple handlers can be defined in parallel to handle different URL paths
        server.createContext("/aap", (HttpExchange t) -> {
            byte[] response = "Hello World from HttpServer on /app - running in parallel to /app/api".getBytes();
            t.sendResponseHeaders(200, response.length);
            OutputStream os = t.getResponseBody();
            os.write(response);
            os.close();
        });
        System.out.println("HTTP Server is running and listening at "+baseUri+"/api" );
    }
}
