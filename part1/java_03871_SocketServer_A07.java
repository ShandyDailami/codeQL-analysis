import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03871_SocketServer_A07 {
    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        // SSL context
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setEndpointIdentificationAlgorithm("Unknown");

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

        // Create SSLContext and key pair
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
        sslServerSocket.setSSLContext(sslContext);

        // Accept client connection
        SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Receive request from client
        String request = in.readLine();
        System.out.println("Received: " + request);

        // Handle request (e.g., authenticate user and respond accordingly)
        if (request.equals("AUTHENTICATE")) {
            out.println("OK");
        } else {
            out.println("FAIL");
        }

        // Close connection
        clientSocket.close();
    }

    static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Do nothing
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Do nothing
        }
    }
}