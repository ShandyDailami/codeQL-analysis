import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;

public class java_07388_SocketServer_A08 {

    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, IOException, KeyManagementException {
        // Create SSLContext using TLS v1.2
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(createKeyManagerFactory(), null, null);

        // Create SSLServerSocketFactory using TLS v1.2
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        // Create ServerSocket using standard port (8080)
        ServerSocket serverSocket = new ServerSocket(8080);

        // Accept a client connection
        Socket clientSocket = serverSocket.accept();

        // Use SSLServerSocket to handle client connection using TLS v1.2
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(clientSocket, 100, null, sslContext.getProtocol());

        // Get the client's SSL socket
        sslServerSocket.setNeedClientAuth(true);

        // Continue accepting client connections
        while (true) {
            Socket socket = sslServerSocket.accept();
            // Handle the client connection...
        }
    }

    private static KeyManagerFactory createKeyManagerFactory() throws KeyStoreException, NoSuchAlgorithmException {
        // Create a KeyStore using a truststore file
        char[] password = "password".toCharArray();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SocketServer.class.getResourceAsStream("/truststore.jks"), password);

        // Create a KeyManagerFactory using the KeyStore
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
        keyManagerFactory.init(keyStore, password);

        return keyManagerFactory;
    }
}