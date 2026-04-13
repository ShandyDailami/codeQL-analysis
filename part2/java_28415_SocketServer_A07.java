import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_28415_SocketServer_A07 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "keyalias";
    private static final int PORT = 8443;

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        // Create a server socket with SSL
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setKeyStore(keyStore);
        sslServerSocket.setKeyStorePassword(KEYSTORE_PASSWORD);

        // Wait for client connections
        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected!");

            // Handle secure data communication
            // ...

            socket.close();
        }
    }
}