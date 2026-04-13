import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_22578_SocketServer_A03 {
    private static final String SSL_PORT = "8443";
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));

        sslServerSocket.setNeedClientAuth(true);

        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) socket.createChannel();

        sslSocket.setNeedClientAuth(true);

        // Continue with the rest of your code here...

        sslSocket.close();
        socket.close();
    }
}