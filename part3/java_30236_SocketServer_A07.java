import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_30236_SocketServer_A07 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) {
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keystore);
            sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);

            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, clientSocket.getInetAddress(), true, false);
                sslSocket.startHandshake();
                sslSocket.setNeedClientAuth(true);

                AuthenticationHandler authenticationHandler = new AuthenticationHandler(sslSocket);
                authenticationHandler.authenticate();
            }
        } catch (CertificateException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}