import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_17498_SocketServer_A01 {

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        // Create a keystore using a set of certificates and private keys
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureServer.class.getResourceAsStream("/client.jks"), "password".toCharArray());

        // Create a SSLServerSocketFactory using our KeyStore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("password");

        // Create a new SSLServerSocket using our SSLServerSocketFactory
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(new InetSocketAddress(8443), 10);

        // Bind the ServerSocket to port 8443
        serverSocket.bind(new InetSocketAddress(8443), 8443);

        System.out.println("Server started on port 8443");

        while (true) {
            // Wait for a client to connect
            SSLServerSocket sock = (SSLServerSocket) serverSocket.accept();

            // Create a new thread to handle communication
            Thread thread = new Thread(new SocketHandler(sock));
            thread.start();
        }
    }
}