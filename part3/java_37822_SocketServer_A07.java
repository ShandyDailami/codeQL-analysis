import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_37822_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());
    private static final String PASSWORD = "securepassword";

    public static void main(String[] args) {
        String host = "localhost";
        int port = 4444;

        try (ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName(host))) {
            logger.info("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Client accepted from " + clientSocket.getRemoteSocketAddress());

                // Authenticate client
                if (authenticate(clientSocket)) {
                    // Create new thread for client
                    new ClientHandler(clientSocket).start();
                } else {
                    logger.warning("Authentication failed for " + clientSocket.getRemoteSocketAddress());
                    clientSocket.close();
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Server failed to start", ex);
        }
    }

    private static boolean authenticate(Socket socket) {
        // Simulate authentication by comparing password
        try {
            return socket.getInputStream().read() == PASSWORD.getBytes()[0];
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error during authentication", ex);
            return false;
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.getInputStream().read(); // Dummy read to simulate receiving data
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error handling client", ex);
            }
        }
    }
}