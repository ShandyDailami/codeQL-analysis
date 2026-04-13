import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

public class java_28207_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        SSLContext sslContext = createSSLContext();
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/hello", new HelloHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port " + PORT);
    }

    private static SSLContext createSSLContext() {
        SSLContext sslContext = null;
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Main.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return sslContext;
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            SSLSocket sslSocket = (SSLSocket) resp.getSocket();
            if (sslSocket != null) {
                sslSocket.setNeedClientAuth(true);
            }

            resp.setStatus(200);
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("Hello, client!");
            out.flush();
        }
    }
}