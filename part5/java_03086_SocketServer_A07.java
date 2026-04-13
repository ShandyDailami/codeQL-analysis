import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.BasicAuthenticator;

public class java_03086_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Create a basic authenticator
        BasicAuthenticator authenticator = new BasicAuthenticator() {
            @Override
            public String getPassword(String username) {
                // Here you can add logic to verify the username and get the password for the user
                // In this example, we just return a hardcoded password
                if ("user".equals(username)) {
                    return "password";
                }
                return null;
            }

            @Override
            public boolean validate(String username, String password) {
                // Here you can add logic to validate the username and password
                // In this example, we just return true if the username and password match
                return "user".equals(username) && "password".equals(password);
            }
        };

        // Set the authenticator for the server
        server.setAuthenticator(authenticator);

        // Create a handler to handle HTTP requests
        server.createContext("/", new MyHandler());

        // Start the server
        server.start();

        System.out.println("Server started on port 8000");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (exchange.getRequestMethod().equals("GET")) {
                String response = "Hello, Authenticated User!";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}