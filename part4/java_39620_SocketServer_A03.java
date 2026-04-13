import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_39620_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    private static final String CLIENT_IP = "127.0.0.1"; // Change this to the IP address you want to accept connections from

    public static void main(String[] args) {
        int port = 1234; // Change this to the port you want to use

        // Create a server socket using SSL
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            sslServerSocket.setNeedClientAuth(true); // Enable client authentication
        } catch (IOException e) {
            logger.severe("Failed to create SSLServerSocket: " + e.getMessage());
            System.exit(1);
        }

        logger.info("Server started. Waiting for client connections on port " + port);

        while (true) {
            try (Socket socket = sslServerSocket.accept()) {
                logger.info("Client connected: " + socket.getRemoteSocketAddress());

                // Read the client's message
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientMessage = in.readLine();
                logger.info("Client message: " + clientMessage);

                // Send a response to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Server message: " + clientMessage);
            } catch (IOException e) {
                logger.severe("Failed to process client connection: " + e.getMessage());
            }
        }
    }
}