import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class java_18784_CredentialValidator_A03 {

    private SSLContext sslContext;
    private HttpServer server;

    public java_18784_CredentialValidator_A03(int port) throws Exception {
        this.server = HttpServer.create(port);
        this.sslContext = SSLContext.getInstance("TLS");
        this.sslContext.init(null, null, null);
        this.server.createContext("/", new MyHandler());
    }

    public void start() {
        this.server.setExecutor(null); // creates a default executor
        this.server.start();
    }

    public void stop() {
        this.server.stop();
    }

    class MyHandler implements HttpHandler {

        @Override
        public void handle(com.sun.net.httpserver.HttpExchange t) throws Exception {
            System.out.println("Handling request.");
            String response = "Hello, World!";
            t.sendResponseHeaders(200, response.length());
            try (OutputStream os = t.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CustomServer server = new CustomServer(8080);
        server.start();

        // simulate a login request
        String loginRequest = "GET / HTTP/1.1\r\nHost: example.com\r\n\r\n";
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, null, null);
        KeyStore keyStore = sslContext.getKeyStore();

        // Inject user credentials
        String credentials = "username=alice&password=1234";
        keyStore.setEntry("alice", sslContext.getCertificate("alice"), new KeyStore.PasswordCallback() {
            @Override
            public char[] getPassword() {
                return credentials.toCharArray();
            }
        }, null);

        HttpsURLConnection connection = (HttpsURLConnection) sslContext.getServerSocketFactory().createServerSocket(8080).createConnection("alice", new String[]{"alice:1234"});
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Host", "example.com");
        connection.connect();

        // read the response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        connection.disconnect();

        server.stop();
    }
}