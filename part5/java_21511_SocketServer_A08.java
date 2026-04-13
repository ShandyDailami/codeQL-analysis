import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_21511_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "C:\\key.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "key";

    public static void main(String[] args) {
        System.out.println("Starting SSL Server...");

        try {
            ServerSocket serverSocket = getServerSocket(true);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Process the SSL socket...

                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ServerSocket getServerSocket(boolean useKeyStore) throws IOException, CertificateException, KeyStoreException {
        if (useKeyStore) {
            return getSSLServerSocket();
        } else {
            return new ServerSocket();
        }
    }

    private static SSLServerSocket getSSLServerSocket() throws IOException, CertificateException, KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(ClassLoader.getSystemResourceAsStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setKeyStore(keyStore);
        sslServerSocket.setNeedClientAuth(true);

        return sslServerSocket;
    }
}