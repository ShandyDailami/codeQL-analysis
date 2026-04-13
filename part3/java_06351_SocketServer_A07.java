import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_06351_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "/path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "/path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";
    private static final String KEY_ALGORITHM = "SunRSASHA1";
    private static final String KEYSTORE_TYPE = "JKS";
    private static final String SERVER_KEYMANAGER = "SunJSSE";
    private static final String TRUSTSTORE = "SunJSSE";

    public static void main(String[] args) throws Exception {

        SSLContext sslContext = getSSLContext(KEYSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD);
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket socketSSL = (SSLSocket) sslServerSocketFactory.createSocket(socket, socket.getInetAddress(), socket.getPort(), true);
            socketSSL.startHandshake();
            socketSSL.setNeedClientAuth(true);
            // rest of the server code...
        }
    }

    private static SSLContext getSSLContext(String keystoreLocation, String keystorePassword, String truststoreLocation, String truststorePassword) throws Exception {
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keystoreLocation, keystorePassword);
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory(truststoreLocation, truststorePassword);
        return SSLContext.getInstance("SSL");
    }

    private static KeyManagerFactory getKeyManagerFactory(String keystoreLocation, String keystorePassword) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        keyStore.load(new java.io.FileInputStream(keystoreLocation), keystorePassword.toCharArray());
        return getKeyManagerFactory(keyStore, KEY_ALGORITHM);
    }

    private static TrustManagerFactory getTrustManagerFactory(String truststoreLocation, String truststorePassword) throws Exception {
        TrustStore trustStore = TrustStore.getInstance(TRUSTSTORE);
        trustStore.load(new java.io.FileInputStream(truststoreLocation), truststorePassword.toCharArray());
        return getTrustManagerFactory(trustStore);
    }

    private static KeyManagerFactory getKeyManagerFactory(KeyStore keyStore, String keyAlgorithm) throws Exception {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(SERVER_KEYMANAGER);
        keyManagerFactory.init(keyStore, keyAlgorithm.toCharArray());
        return keyManagerFactory;
    }

    private static TrustManagerFactory getTrustManagerFactory(TrustStore trustStore) throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TRUSTSTORE);
        trustManagerFactory.init(trustStore);
        return trustManagerFactory;
    }
}