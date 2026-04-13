import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_25735_SocketServer_A07 {
    private static final String[] authorizedClients = { "127.0.0.1", "192.168.1.1" };
    private static SSLServerSocket serverSocket = null;
    private static BufferedReader in = null;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client authentication...");

        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        System.out.println("Client authenticated successfully");

        // Read the client's public key and perform the authentication
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = "password".toCharArray();
        keyStore.load(new FileInputStream("client.jks"), password);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, null, new SecureRandom());

        // Setup a BufferedReader for client communication
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Send a welcome message to the client
        String message = "Welcome to the server!";
        OutputStream out = clientSocket.getOutputStream();
        out.write(message.getBytes());

        // Close the connection
        clientSocket.close();
    }
}