import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_04870_SocketServer_A03 {

    private static final String KEY_STORE = "server.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory(KEY_STORE, KEY_STORE_PASSWORD, KEY_ALIAS);
            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.getServerSocket(54321);
            SSLServerSocket sslServer = (SSLServerSocket) serverSocket;
            sslServer.setNeedClientAuth(true);

            System.out.println("Server started");
            while (true) {
                Socket socket = sslServer.accept();
                SSLSocket sslSocket = (SSLSocket) socket;
                System.out.println("Client connected");

                // Handle client connection here
            }
        } catch (KeyStoreException | CertificateException | IOException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(String keyStorePath, String keyStorePassword, String keyAlias) throws KeyStoreException, CertificateException, IOException, KeyManagementException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());
        keyStore.setKeyEntry(keyAlias, keyStorePassword.toCharArray(), keyStorePassword.toCharArray(), new ArrayList<Password>());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.init(keyStore, keyAlias, new ArrayList<String>());
        return sslServerSocketFactory;
    }
}