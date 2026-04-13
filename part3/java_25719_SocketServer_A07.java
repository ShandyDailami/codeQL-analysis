import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.Authenticator;

public class java_25719_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/restricted", new MyHandler());

        // Create an authenticator
        Authenticator<String> authenticator = new BasicAuthenticator("Secure Area") {
            @Override
            public boolean checkCredentials(String userName, String password) {
                // In a real application, you'd want to call your own authentication method here.
                // This is just a placeholder for now.
                return userName.equals("admin") && password.equals("password");
            }
        };

        server.setAuthenticator(authenticator);

        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"GET".equals(exchange.getRequestMethod())) {
                sendError(exchange, 405, "Method Not Allowed");
            } else {
                // Just return a simple response
                sendResponse(exchange, 200, "Hello, World!");
            }
        }

        private void sendResponse(HttpExchange exchange, int code, String response) throws IOException {
            exchange.sendResponseHeaders(code, response.length());
            OutputStream out = exchange.getResponseBody();
            out.write(response.getBytes());
            out.close();
        }

        private void sendError(HttpExchange exchange, int code, String message) throws IOException {
            exchange.sendResponseHeaders(code, message.length());
            OutputStream out = exchange.getResponseBody();
            out.write(message.getBytes());
            out.close();
        }
    }
}