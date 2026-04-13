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

public class java_01468_SocketServer_A03 {
    private static final String KEYSTORE = "mykeystore.jks";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String TRUSTSTORE = "mytruststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE), KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(TRUSTSTORE), TRUSTSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keyStore);
            sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);
            sslServerSocketFactory.setTrustStore(trustStore);
            sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);

            ServerSocket sslServerSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                Socket socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(socket, socket.getInetAddress());
                sslSocket.startHandshake();
                System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " connected.");
                // Handle the secure socket here...
            }
        } catch (KeyStoreException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}