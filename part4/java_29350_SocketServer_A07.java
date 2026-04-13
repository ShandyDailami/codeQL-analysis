import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_29350_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystore_password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "truststore_password";

    public static void main(String[] args) {
        runServer(9999, KEYSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD);
    }

    private static void runServer(int port, String keystoreLocation, String keystorePassword,
                                   String truststoreLocation, String truststorePassword) {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);

            socket = sslServerSocket.accept();

            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            // Continue with authentication...
            if (sslSocket.isClientHelloSupported(SSLServerSocket.getSupportedVersion())) {
                sslSocket.startHandshake();
            }

            // Continue with secure communication...
            // Now you can safely communicate with the client

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                try {
                    sslServerSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}