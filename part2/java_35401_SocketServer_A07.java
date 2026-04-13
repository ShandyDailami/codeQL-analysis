import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_35401_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServer(8443);
    }

    public static void SSLServer(int port) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        // Create a KeyStore that will contain our private key and certificate
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] keyStorePassword = "mypass".toCharArray();
        char[] keyPassword = "mypass".toCharArray();

        // Create a truststore that will contain our certificate
        TrustStore trustStore = TrustStore.getInstance("JKS");

        // Create a self-signed certificate for testing
        KeyStoreUtil.createSelfSignedCertificate("localhost", keyStore, trustStore, "selfsignedcert", keyPassword);

        // Load the certificate and key into TrustStore and KeyStore
        trustStore.load(new FileInputStream("truststore.jks"), keyStorePassword);

        // Setup SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, keyPassword, trustStore);

        // Setup server socket
        serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);

        // Accept client connections
        System.out.println("Waiting for client connection...");
        while ((clientSocket = serverSocket.accept()) != null) {
            System.out.println("Accepted client connection from: " + clientSocket.getRemoteSocketAddress());

            // Create an auth-failure listener and wrap the socket with it
            SSLSocket sslClientSocket = (SSLSocket) sslContext.getClientSocket();
            sslClientSocket.setNeedClientAuth(true);
            sslClientSocket.setAuthFailCallback(new AuthFailureListener());

            // Send a greeting message to the client
            OutputStream out = clientSocket.getOutputStream();
            DataOutputStream wr = new DataOutputStream(out);
            wr.writeUTF("Hello Client, Welcome to SSL Server!");
            wr.close();

            // Close the connection
            clientSocket.close();
        }
        serverSocket.close();
    }

    public static class AuthFailureListener implements SSLAuthFailureCallback {
        public void failed(SSLSocket s) {
            System.out.println("Auth failure!");
        }
    }
}