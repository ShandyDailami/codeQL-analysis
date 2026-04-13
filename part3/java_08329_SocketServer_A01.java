import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_08329_SocketServer_A01 {
    private static final String SSL_KEYSTORE = "src/main/resources/ssl_keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE = "src/main/resources/ssl_truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException {
        // Load the KeyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream is = getClass().getResourceAsStream(SSL_KEYSTORE)) {
            keyStore.load(is, SSL_KEYSTORE_PASSWORD.toCharArray());
        }

        // Load the TrustStore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        try (InputStream is = getClass().getResourceAsStream(SSL_TRUSTSTORE)) {
            trustStore.load(is, SSL_TRUSTSTORE_PASSWORD.toCharArray());
        }

        // Initialize the SSLServerSocketFactory with the KeyStore and TrustStore
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword(SSL_KEYSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(trustStore);
        sslServerSocketFactory.setTrustStorePassword(SSL_TRUSTSTORE_PASSWORD);

        // Create an SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

        // Accept client connections
        while (true) {
            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();

            // Create an input stream and output stream
            try (InputStream in = clientSocket.getInputStream();
                 OutputStream out = clientSocket.getOutputStream()) {

                // Read from the client and write to the server
                byte[] bytes = new byte[1024];
                int length;
                while ((length = in.read(bytes)) != -1) {
                    out.write(bytes, 0, length);
                }
            }
        }
    }
}