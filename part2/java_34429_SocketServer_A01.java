import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_34429_SocketServer_A01 {
    private static final String SSL_PORT = "8443"; // SSL Port
    private static final String KEY_STORE = "client.keystore";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE = "truststore.jks";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        InetSocketAddress addr = new InetSocketAddress(8080);
        SSLServerSocket sslServerSocket = null;

        try {
            SSLContext sslContext = createSSLContext(KEY_STORE, KEY_STORE_PASSWORD, TRUST_STORE, TRUST_STORE_PASSWORD);
            sslServerSocket = (SSLServerSocket) sslContext.getServerSocket(addr);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                processRequest(sslSocket);
            }
        } finally {
            sslServerSocket.close();
        }
    }

    private static void processRequest(SSLSocket sslSocket) {
        // process request
    }

    private static SSLContext createSSLContext(String keyStorePath, String keyStorePassword, String trustStorePath, String trustStorePassword) throws Exception {
        // Load Keystore and Truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keyStorePath), keyStorePassword.toCharArray());

        TrustStore trustStore = TrustStore.getInstance("JKS");
        trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(trustStorePath), trustStorePassword.toCharArray());

        // Setup KeyManagerFactory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKS");
        kmf.init(keyStore, keyStorePassword.toCharArray());

        // Setup TrustManagerFactory
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunJSSE");
        tmf.init(trustStore);

        // Create SSLContext using KeyManagerFactory and TrustManagerFactory
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return sslContext;
    }
}