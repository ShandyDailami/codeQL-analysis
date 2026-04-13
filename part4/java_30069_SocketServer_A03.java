import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_30069_SocketServer_A03 {

    private static final int PORT = 1234;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("127.0.0.1");

        // Create a pool of worker threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Create SSL Server Socket Factory and set it to accept incoming connections
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT, 100, address);
        sslServerSocket.setNeedClientAuth(true);

        // Load the client certificates
        sslServerSocket.setCertificateExtensions("SSL-Client-Cert");
        sslServerSocket.setRenegotiationEnabled(false);

        // Set the key store and password
        sslServerSocket.setKeyStore(KEYSTORE_LOCATION, KEYSTORE_PASSWORD.toCharArray());
        sslServerSocket.setTrustStore(TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD.toCharArray());

        System.out.println("Server Started with SSL and KeyStore " + KEYSTORE_LOCATION);

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            executorService.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_30069_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client connections and communication
        }
    }
}