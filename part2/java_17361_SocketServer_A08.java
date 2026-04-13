import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_17361_SocketServer_A08 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            // Set up the server socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4445);

            // Set up the SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
            serverSocket.setSSLContext(sslContext);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Handle the client connection
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Create input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Send a welcome message to the client
            output.write("Welcome to the server!\n".getBytes());

            // Read the client's message
            byte[] bytes = new byte[256];
            int bytesRead = input.read(bytes);
            String message = new String(bytes, 0, bytesRead);

            // Respond to the client
            output.write("Hello, " + message + "!\n".getBytes());

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TrustAllCerts extends X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }
    }
}