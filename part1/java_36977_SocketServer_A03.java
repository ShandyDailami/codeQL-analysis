import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.*;

public class java_36977_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Initialize server socket
        ServerSocket serverSocket = new ServerSocket(54321, 50, InetAddress.getByName("localhost"));

        // Load SSL keystore and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream("/truststore.jks"), "password".toCharArray());

        // Initialize key manager factory
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "password".toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLServerSocket socket = new SSLServerSocket(serverSocket, keyManagerFactory, trustManagerFactory);

        while (true) {
            Socket clientSocket = socket.accept();
            System.out.println("Client connected");
            // ... handle client socket ...
        }
    }
}