import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_15681_SocketServer_A01 {

    private static final String KEYSTORE = "keystore.jks";
    private static final char[] KEYSTORE_PASSWORD = "password".toCharArray();
    private static final char[] KEY_PASSWORD = "password".toCharArray();
    private static final String ALIAS = "server";

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        // Load the KeyStore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE), KEYSTORE_PASSWORD);

        // Setup SSL ServerSocketFactory
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Create a new ServerSocket with the SSL ServerSocketFactory
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Accept SSL Sockets
        SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

        // Setup the key and certificate for the SSLSocket
        sslSocket.setSSLParameters(new SSLParameters(KeyStore.getInstance("JKS"), KEY_PASSWORD, new InetAddress[] {}, null, KEY_PASSWORD));

        // Continue with the socket communication...

        // Don't forget to close the sockets and keystores when you're done...
        sslSocket.close();
        serverSocket.close();
    }
}