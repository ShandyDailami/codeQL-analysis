import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class java_00028_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/secure", new AuthenticationHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class AuthenticationHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String auth = getAuth(t.getRequestHeaders());

            if (auth != null && auth.equals("Basic " + getBase64Credentials(t.getRequestHeaders()))) {
                // Authentication successful
                t.sendResponseHeaders(200, -1);
            } else {
                // Authentication failed
                t.sendResponseHeaders(401, -1);
                PrintWriter pw = t.getResponseHeaders().put("WWW-Authenticate", "Basic realm=\"Restricted Access\"");
                String response = "Unauthorized";
                t.sendResponseHeaders(401, response.length());
                t.getResponseBody().write(response.getBytes());
                pw.close();
            }

            t.close();
        }

        private String getAuth(java.util.Map<String, String> headers) {
            String auth = headers.get("Authorization");
            if (auth == null) {
                return null;
            }
            int space = auth.indexOf(" ");
            if (space == -1) {
                return null;
            }
            String method = auth.substring(0, space);
            if (!method.equalsIgnoreCase("Basic")) {
                return null;
            }
            return auth.substring(space + 1);
        }

        private String getBase64Credentials(java.util.Map<String, String> headers) {
            return new String(Base64.getDecoder().decode(getAuth(headers)), StandardCharsets.UTF_8);
        }
    }
}