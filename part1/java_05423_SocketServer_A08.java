import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class java_05423_SocketServer_A08 {

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException, KeyManagementException {

        // Create a KeyStore that contains the private key and certificate for the server
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("server.jks"), "password".toCharArray());

        // Create a SSLContext using the KeyStore
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, null);

        // Create a SSLServerSocketFactory using the SSLContext
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        ServerSocket serverSocket = null;
        try {
            serverSocket = (ServerSocket)sslServerSocketFactory.createServerSocket(8080);
            while(true) {
                SSLSocket clientSocket = (SSLSocket)sslServerSocketFactory.createSocket(serverSocket.getInetAddress(), serverSocket.getPort());
                clientSocket.startHandshake();
                // Proceed with communication using the SSLSocket
                // ...

                // Closing the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null)
                serverSocket.close();
        }
    }
}