import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class java_41098_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new TestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello, authenticated user!";
            if (validateUser(t.getRequestHeaders().getFirst("Authorization"))) {
                response = "Hello, authorized user!";
            }
            t.sendResponseHeaders(200, response.length());
            try (PrintWriter out = t.getResponseBody()) {
                out.write(response);
                out.close();
            }
        }

        private boolean validateUser(String authorization) {
            // This is a simple example of a password-based authentication.
            // In a real-world application, you would need to use a more secure
            // method of authenticating the user, such as comparing the hash of the
            // entered password to a stored hash.
            return authorization != null && authorization.equals("Basic " + Base64.getEncoder().encodeToString("user:pass".getBytes()));
        }
    }
}