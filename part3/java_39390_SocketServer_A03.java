import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_39390_SocketServer_A03 {

    private static Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        String username = "user";
        String password = "pass";

        // Create server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) SSLServerSocketFactory.createServerSocket(9090, 1000, null, InetAddress.getByName("localhost"));
        } catch (Exception e) {
            logger.severe("Failed to create SSL ServerSocket.");
            e.printStackTrace();
            System.exit(1);
        }

        // Accept client connections
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                if (authenticate(socket, username, password)) {
                    logger.info("Client connected.");
                    // Handle client communication here
                } else {
                    logger.info("Authentication failed. Disconnecting.");
                    socket.close();
                }
            } catch (Exception e) {
                logger.severe("Failed to accept client connection.");
                e.printStackTrace();
            }
        }
    }

    private static boolean authenticate(Socket socket, String username, String password) {
        // This is a simple authentication process. In a real-world scenario, it should use secure ways to authenticate
        // like using a database or a cryptographic hash
        return username.equals(socket.getRemoteSocketAddress().toString()) && password.equals("pass");
    }
}