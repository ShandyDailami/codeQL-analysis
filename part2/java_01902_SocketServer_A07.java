import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_01902_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "/path/to/keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String ALGORITHM = "SunJSSE";

    public static void main(String[] args) {
        try {
            // Load KeyStore and TrustStore
            KeyStore keyStore = KeyStore.getInstance(ALGORITHM);
            keyStore.load(new java.io.FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            TrustStore trustStore = TrustStore.getInstance(ALGORITHM);
            trustStore.load(new java.io.FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

            // Load KeyManagers
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(ALGORITHM);
            keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(ALGORITHM);
            trustManagerFactory.init(trustStore);

            // Create SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory()
                    .init(new InetAddress(InetAddress.getLoopbackAddress().getHostAddress()), 12345, keyManagerFactory,
                            trustManagerFactory);

            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket();

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress().getHostAddress());

                // Handle client
                new Handler(clientSocket).start();
            }
        } catch (CertificateException | IOException | java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}