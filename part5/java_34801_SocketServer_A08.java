import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_34801_SocketServer_A08 {
    private static final String CLIENT_KEYSTORE_PATH = "path_to_your_client_keystore.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "your_client_keystore_password";

    public static void main(String[] args) throws Exception {
        // Create a SSL server socket
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, SSLServerSocket.getDefaultSSLParameters());

        // Enable SSL on the server socket
        serverSocket.setNeedClientAuth(true);

        // Load the client keystore
        KeyStore clientKeystore = KeyStore.getInstance("JKS");
        clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE_PATH), CLIENT_KEYSTORE_PASSWORD.toCharArray());

        // Set up a KeyManagerFactory using the client keystore
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyFactory.getDefaultAlgorithm());
        keyManagerFactory.init(clientKeystore, CLIENT_KEYSTORE_PASSWORD.toCharArray());

        // Create a TrustManagerFactory using the default algorithm and the client keystore
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(clientKeystore);

        // Create a SSLContext using the key and trust managers
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        // Accept client connections
        Socket client = serverSocket.accept();

        // Set up SSL for the client socket
        SSLSocket sslClient = (SSLSocket) sslContext.wrapSocket(client);

        // Send a response back to the client
        DataOutputStream out = new DataOutputStream(sslClient.getOutputStream());
        out.writeBytes("Hello, client!\n");
        sslClient.close();
    }
}