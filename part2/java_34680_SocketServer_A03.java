import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_34680_SocketServer_A03 {
    private static final String KEYSTORE_PATH = "path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_PATH = "path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";
    private static final int PORT = 8443;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = null;

            // Load SSL certificate and key into keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

            // Load truststore for client certificate verification
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(getClass().getResourceAsStream(TRUSTSTORE_PATH), TRUSTSTORE_PASSWORD.toCharArray());

            // Setup trust manager factory to provide truststore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            // Setup SSLServerSocketFactory to use keystore and truststore
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keyStore);
            sslServerSocketFactory.setTrustStore(trustStore);
            sslServerSocketFactory.setKeyPassword(KEYSTORE_PASSWORD);
            sslServerSocketFactory.setTrustAll(true);

            // Setup server socket to use SSLServerSocketFactory
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket socketSSl = (SSLSocket) sslServerSocketFactory.createSocket(socket, socket.getInetAddress(),
                        socket.getLocalPort(), true);
                socketSSl.setNeedClientAuthentication(true);
                socketSSl.setTrustManagerFactory(trustManagerFactory);

                // Start reading from SSLSocket
                new SSLReadThread(socketSSl).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }
}