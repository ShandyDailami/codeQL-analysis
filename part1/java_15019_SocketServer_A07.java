import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_15019_SocketServer_A07 {
    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Create an SSLServerSocket and bind it to the port
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT)) {
            sslServerSocket.setNeedClientAuth(true);

            ExecutorService executorService = Executors.newFixedThreadPool(10);

            while (true) {
                try {
                    Socket clientSocket = sslServerSocket.accept();
                    executorService.execute(new ClientHandler(clientSocket));
                } catch (SocketException e) {
                    System.out.println("A client disconnected.");
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Process the client's request
            // For example, print the client's IP address and port number
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress() + ", port: " + socket.getPort());
        }
    }
}