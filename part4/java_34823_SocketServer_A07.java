import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;

public class java_34823_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/auth", new AuthHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class AuthHandler implements com.sun.net.httpserver.HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            if ("GET".equals(t.getRequestMethod()) &&
                t.getRequestURI().equals("/auth")) {
                if ("Basic ".compareTo(t.getRequestHeaders().get("Authorization").get(0)) != 0) {
                    String Credential = t.getRequestHeaders().get("Authorization").get(0);
                    String plainCredential = new String(Base64.getDecoder().decode(Credential.substring(5)), StandardCharsets.UTF_8);
                    String username = plainCredential.split(":")[0];
                    String password = plainCredential.split(":")[1];
                    if ("username".equals(username) && "password".equals(password)) {
                        t.sendResponseHeaders(200, -1);
                    } else {
                        t.sendResponseHeaders(401, -1);
                    }
                } else {
                    t.sendResponseHeaders(401, -1);
                }
            }
            t.close();
        }
    }
}