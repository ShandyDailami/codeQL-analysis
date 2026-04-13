import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_34645_SocketServer_A03 {
    private static final String KEY_STORE = "server.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE = "client.jks";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        ServerSocket socket = null;

        // Create a KeyStore and load it with our server certificate
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEY_STORE), KEY_STORE_PASSWORD.toCharArray());

        // Create a KeyStore and load it with our client certificate
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(TRUST_STORE), TRUST_STORE_PASSWORD.toCharArray());

        // Setup SSL ServerSocketFactory
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword(KEY_STORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(trustStore);
        sslServerSocketFactory.setTrustStorePassword(TRUST_STORE_PASSWORD);

        // Setup ServerSocket
        socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        while (true) {
            // Wait for a client connection
            Socket client = socket.accept();

            // Setup SSL Socket
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            sslSocketFactory.setKeyStore(keyStore);
            sslSocketFactory.setKeyStorePassword(KEY_STORE_PASSWORD);
            sslSocketFactory.setTrustStore(trustStore);
            sslSocketFactory.setTrustStorePassword(TRUST_STORE_PASSWORD);
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(0);
            sslServerSocket.bind(null, 8080);

            // Setup SSL Socket for communication with client
            SSLSocket clientSocket = (SSLSocket) sslSocketFactory.createSocket(client, client.getInetAddress(), false, true);
            clientSocket.startHandshake();

            // Communicate with client
            // ...
        }
    }
}