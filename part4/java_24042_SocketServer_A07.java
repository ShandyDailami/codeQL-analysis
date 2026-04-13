import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ServerSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class java_24042_SocketServer_A07 {

    private static SSLServerSocket sslServerSocket;
    private static ServerSocket serverSocket;
    private static SSLContext sslContext;

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        // Step 1: Setup the SSLContext with a KeyStore containing our private key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SocketServer.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "password".toCharArray());

        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, null, null);

        // Step 2: Setup the ServerSocket
        serverSocket = (ServerSocket) sslContext.getServerSocket(8443);
        serverSocket.setReuseAddress(true);

        // Step 3: Bind the ServerSocket to a port
        sslServerSocket = (SSLServerSocket) serverSocket.accept();
        sslServerSocket.setReuseAddress(true);

        // Step 4: Setup the SSLSocket
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setReuseAddress(true);

        // Now you can use sslSocket to send/receive data
        System.out.println("Client connected");
        sslSocket.close();
    }
}