import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_26500_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = null;
            if (args[0].equals("-ssl")) {
                serverSocket = createSecureServerSocket(9001);
            } else {
                serverSocket = createServerSocket(9001);
            }

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createInstance("SSLv3");
                sslSocket.setNeedClientAuth(true);
                sslSocket.setEnabledCipherSuites(sslSocket.getSupportedCipherSuites());

                sslSocket.useClientMode();

                // ... perform integrity check here

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    private static SSLServerSocket createSecureServerSocket(int port) throws IOException {
        SSLServerSocket sslServerSocket = new SSLServerSocket(port);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setEnabledCipherSuites(sslServerSocket.getSupportedCipherSuites());
        return sslServerSocket;
    }
}