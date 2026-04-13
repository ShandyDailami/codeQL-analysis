import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_23080_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "mykeystore.jks";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String KEY_PASSWORD = "mypassword";
    private static final String ALGORITHM = "SunECB";
    private static final int KEY_SIZE = 256;

    public static void main(String[] args) throws Exception {

        // Create a custom SSLServerSocketFactory with our custom keyStore and TrustStore
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory = sslServerSocketFactory.setKeyStore(KEYSTORE_LOCATION, KEY_PASSWORD, ALGORITHM);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = sslServerSocket.accept();
                System.out.println("Accepted connection from: " + clientSocket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException ex) {
            System.out.println("Exception caught when trying to listen on port " + PORT + " or listening for a connection");
            ex.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_23080_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}