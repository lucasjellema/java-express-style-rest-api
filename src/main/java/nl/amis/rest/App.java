package nl.amis.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class App {
    private final static int port = 8765;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/app", (HttpExchange t) -> {
            byte[] response = "Hello World from HttpServer".getBytes();
            t.sendResponseHeaders(200, response.length);
            OutputStream os = t.getResponseBody();
            os.write(response);
            os.close();
        });
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("HTTP Server is running and listening at " + server.getAddress() + "/app");
    }
}
