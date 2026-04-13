import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_09927_SocketServer_A07 {

    private static final String SSL_PORT = "8443";
    private static final String KEY_STORE_PATH = "path_to_your_keystore.jks";
    private static final String KEY_STORE_PASSWORD = "your_keystore_password";
    private static final String TRUST_STORE_PATH = "path_to_your_truststore.jks";
    private static final String TRUST_STORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        sslServerSocketFactory.setKeyStore(KEY_STORE_PATH, KEY_STORE_PASSWORD.toCharArray());
        sslServerSocketFactory.setKeyStorePassword(KEY_STORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(TRUST_STORE_PATH, TRUST_STORE_PASSWORD.toCharArray());
        sslServerSocketFactory.setTrustStorePassword(TRUST_STORE_PASSWORD);

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setSoTimeout(60000);

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Here you can write your server logic

            sslSocket.close();
        }
    }
}