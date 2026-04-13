import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_01778_SocketServer_A08 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystore_password";
    private static final String KEY_ALIAS = "key_alias";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(443, null, null);
        sslServerSocket.setNeedClientAuth(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream inputStream = getClass().getResourceAsStream(KEYSTORE_PATH)) {
            keyStore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
        }

        sslServerSocket.setKeyStore(keyStore);
        sslServerSocket.setKeyStorePassword(KEYSTORE_PASSWORD);

        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) socket.getTransportSocket();

        try (OutputStream outputStream = sslSocket.getOutputStream()) {
            outputStream.write("Hello, Client!".getBytes());
        }

        sslServerSocket.close();
    }
}