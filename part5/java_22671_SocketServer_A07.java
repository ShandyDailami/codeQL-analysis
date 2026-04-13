import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_22671_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket server = null;
        SSLServerSocket sslServer = null;

        try {
            // Create a new SSLServerSocket for port 8888
            server = new ServerSocket(port);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("src/main/resources/keystore.jks"), "password".toCharArray());
            SSLServerSocketFactory sslServerFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServer = (SSLServerSocket) sslServerFactory.createServerSocket(port, null, keyStore, new TrustManager[] { new TrustManagerSSL() });
            System.out.println("Server started at port " + port);

            // Wait for a client to connect
            Socket clientSocket = sslServer.accept();
            System.out.println("Client connected");

            // Read from the client
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Write to the client
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello from Server!");

            // Close the connection
            clientSocket.close();

        } finally {
            sslServer.close();
            server.close();
        }
    }

    // TrustManager that trusts all SSL certificates
    static class TrustManagerSSL implements TrustManager, javax.net.ssl.SSLServerSocketFactory.TrustManager {
        public String[] getSupportedSSLTypes() {
            return new String[]{"SSL"};
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs) {
        }

        public X509Certificate[] getAcceptedCerts() {
            return new X509Certificate[0];
        }
    }
}