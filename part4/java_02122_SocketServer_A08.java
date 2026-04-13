import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_02122_SocketServer_A08 {
    private static final String SSL_KEY_STORE = "ssl_key.jks";
    private static final String SSL_KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE = "truststore.jks";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            // Load the SSL certificate and key
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(SecureSocketServer.class.getResourceAsStream(SSL_KEY_STORE), SSL_KEY_STORE_PASSWORD.toCharArray());

            // Load the certificate of the CA that signed the server's certificate
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(SecureSocketServer.class.getResourceAsStream(TRUST_STORE), TRUST_STORE.toCharArray());

            // Set up a trust manager that trusts any certificate from the key store
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);

            // Set up the SSL server socket
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444, tmf, new javax.net.ssl.SSLServerSocketFactory(keyStore));

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setUseClientMode(true);
                sslSocket.startHandshake();
                // Process the SSLSocket here
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}