import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.security.auth.callback.UnsupportedCallbackException;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.BasicAuthenticator;

public class java_34349_SocketServer_A07 {

    private static final String AUTH_METHOD = "Basic";
    private static final String AUTH_HEADER = "Authorization";
    private static final String SECURE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(4445);
        server.createContext("/secure", new SecureHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class SecureHandler implements com.sun.net.httpserver.HttpHandler {

        @Override
        public void handle(HttpExchange t) throws IOException {
            if (t.getRequestMethod().equalsIgnoreCase("GET")) {
                if (authenticate(t.getRequestHeaders())) {
                    // Authenticated, serve content
                    String response = "Hello, Secure World!";
                    t.sendResponseHeaders(200, response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    // Not authenticated, send 401
                    t.sendResponse(401, "Unauthorized");
                }
            }
            t.close();
        }

        private boolean authenticate(String[] headers) throws UnsupportedCallbackException {
            Authenticator auth = new BasicAuthenticator() {
                @Override
                public boolean checkCredentials(String username, String password) {
                    return username.equals("user") && hashPassword(password).equals("password");
                }
            };

            return auth.authenticate(t, AUTH_HEADER, AUTH_METHOD);
        }

        private String hashPassword(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                return Base64.getEncoder().encodeToString(digest);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}