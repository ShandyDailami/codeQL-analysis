import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_26676_SocketServer_A01 {

    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_TRUSTSTORE = "client.truststore";
    private static final String CLIENT_TRUSTSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_TRUSTSTORE = "server.truststore";
    private static final String SERVER_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException {

        // Create SSL Server Socket
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        sslServerSocket.setNeedClientAuth(true);

        // Load Keystore and Truststore
        System.setProperty("javax.net.ssl.keyStore", CLIENT_KEYSTORE);
        System.setProperty("javax.net.ssl.keyStorePassword", CLIENT_KEYSTORE_PASSWORD);
        System.setProperty("javax.net.ssl.trustStore", SERVER_TRUSTSTORE);
        System.setProperty("javax.net.ssl.trustStorePassword", SERVER_TRUSTSTORE_PASSWORD);

        while (true) {

            // Accept Connection
            SSLSocket sslSocket = null;
            try {
                sslSocket = (SSLSocket) sslServerSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            // Handle Connection
            new ClientHandler(sslSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_26676_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client
        }
    }
}