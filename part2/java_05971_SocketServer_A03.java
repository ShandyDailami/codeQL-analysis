import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_05971_SocketServer_A03 {

    private static final String KEYSTORE = "keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "key";

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {

        // Load a KeyStore with our private key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SSLServer.class.getResourceAsStream("/keystore.jks"), KEYSTORE_PASSWORD.toCharArray());

        // Set the KeyStore and Password for the KeyStore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

        // Bind our SSLServerSocket to port 8000
        SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();

        // Perform secure operations
        InetAddress ip = clientSocket.getInetAddress();
        System.out.println("Client IP: " + ip.getHostAddress());

        // Close the connection
        clientSocket.close();
    }
}