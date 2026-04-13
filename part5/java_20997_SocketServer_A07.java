import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_20997_SocketServer_A07 {

    private static final String KEYSTORE = "src/main/resources/client.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "src/main/resources/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String ALGORITHM = "SunEC";

    public static void main(String[] args) throws Exception {
        ServerSocketFactory sslServerSocketFactory =
                SSLServerSocketFactory.newInstance(
                        (KeyManagerFactory) KeyStoreUtils.getKeyManagerFactory(KEYSTORE, KEYSTORE_PASSWORD.toCharArray()),
                        (TrustStore) KeyStoreUtils.getTrustStore(TRUSTSTORE, TRUSTSTORE_PASSWORD.toCharArray()),
                        ALGORITHM);
        ServerSocket serverSocket = sslServerSocketFactory.createServerSocket(1234);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, clientSocket.getInetAddress(), true, false);
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();

            if (sslSocket.getState().ordinal() != SSLState.HANDSHAKE_COMPLETED) {
                throw new AuthFailureException("Handshake failed: " + sslSocket.getState().name());
            }

            InetAddress address = sslSocket.getLocalAddress();
            System.out.println("Connected to " + address.getHostAddress());

            // Here you can handle the SSLSocket

            sslSocket.close();
        }
    }

    static class AuthFailureException extends Exception {
        public java_20997_SocketServer_A07(String message) {
            super(message);
        }
    }

    static class KeyStoreUtils {
        static KeyStore getKeyStore(String path, char[] password) throws Exception {
            return KeyStore.getInstance("JKS");
        }

        static KeyStore getTrustStore(String path, char[] password) throws Exception {
            return getKeyStore(path, password);
        }

        static KeyManagerFactory getKeyManagerFactory(String path, char[] password) throws Exception {
            return KeyManagerFactory.getInstance("SunKeyManagerFactory");
        }
    }
}