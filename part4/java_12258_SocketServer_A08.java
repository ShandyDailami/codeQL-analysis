import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_12258_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_for_keystore";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password_for_truststore";
    private static final String KEY_ALIAS = "socket_server";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory(KEYSTORE_LOCATION, TRUSTSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_PASSWORD);
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected!");

            // Handle client connection here

            clientSocket.close();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(String keystoreLocation, String truststoreLocation, String keystorePassword, String truststorePassword) throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new File(keystoreLocation), keystorePassword.toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new File(truststoreLocation), truststorePassword.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword(keystorePassword);
        sslServerSocketFactory.setTrustStore(trustStore);
        sslServerSocketFactory.setTrustStorePassword(truststorePassword);

        return sslServerSocketFactory;
    }
}