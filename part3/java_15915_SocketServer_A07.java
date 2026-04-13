import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_15915_SocketServer_A07 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_of_keystore";
    private static final String KEY_ALIAS = "alias_of_key";

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory(KEYSTORE_LOCATION, KEYSTORE_PASSWORD, KEY_ALIAS);
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createSocket(socket.getInetAddress(), socket.getPort(), true);
                sslSocket.setNeedClientAuth(true);
                sslSocket.setUseClientMode(true);

                sslSocket.startHandshake();

                if (sslSocket.getSession() != SSLSession.HANDSHAKE_COMPLETE) {
                    System.out.println("Handshake failed.");
                    sslSocket.close();
                    continue;
                }

                // Process the encrypted data...

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(String keystoreLocation, String keystorePassword, String keyAlias) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            InputStream keystoreInputStream = new FileInputStream(keystoreLocation);
            keyStore.load(keystoreInputStream, keystorePassword.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            return (SSLServerSocketFactory) sslServerSocketFactory.createServerSocketFactory(keyStore, keyAlias, new java.security.cert.Certificate[]{});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}