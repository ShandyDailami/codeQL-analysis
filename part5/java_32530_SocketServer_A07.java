import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_32530_SocketServer_A07 {

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        // create a KeyStore with a self-signed certificate
        char[] password = "password".toCharArray();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, password);

        // create a KeyManagerFactory that uses the KeyStore
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);

        // create an SSLContext that uses the KeyManagerFactory
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        // create an SSLServerSocket that uses the SSLContext
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));

        // wait for client connections
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected!");

            // handle the client connection
            // ...

            clientSocket.close();
        }
    }
}