import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_10622_SocketServer_A01 {

    private static final String CLIENT_CERT_PATH = "client.jks";
    private static final String TRUST_STORE_PATH = "truststore.jks";

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Load certificate and truststore
            SSLServerCertificateExtractor extractor = new SSLServerCertificateExtractor(CLIENT_CERT_PATH, TRUST_STORE_PATH);

            // Create SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            // Accept client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuth(true);

            // Get SSL certificate from client
            SSLCertificate clientCert = extractor.getCertificate(clientSocket);

            // Verify client's certificate
            if (extractor.verifyClientCertificate(clientCert)) {
                System.out.println("Client's certificate is valid");

                // Send message back to client
                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello from Server!");
            } else {
                System.out.println("Client's certificate is invalid");
            }

            // Close connections
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}