import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14170_SocketServer_A08 {
    private static final String SSL_KEYSTORE_FILENAME = "sslkeystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE_FILENAME = "slltruststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Create the server socket
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Load the SSL certificate and private key into key stores
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(SSL_KEYSTORE_FILENAME), SSL_KEYSTORE_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream(SSL_TRUSTSTORE_FILENAME), SSL_TRUSTSTORE_PASSWORD.toCharArray());

        // Create SSLContext with the private key and trustStore
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, trustStore);

        // Accept and process client requests
        while (true) {
            SSLSocket clientSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(serverSocket.accept());

            // Write response to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, Client!");
        }
    }
}