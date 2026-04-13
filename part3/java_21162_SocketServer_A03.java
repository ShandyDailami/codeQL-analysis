import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_21162_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    private final int port;
    private final SSLServerSocketFactory sslServerSocketFactory;

    public java_21162_SocketServer_A03(int port) {
        this.port = port;
        this.sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    }

    public void startServer() {
        logger.log(Level.INFO, "Starting Socket Server on port {0}.", port);

        Runnable socketTask = new SocketTask(port);

        // Start a new thread for handling each client connection.
        new Thread(socketTask).start();
    }

    public static void main(String[] args) {
        new SocketServer(8080).startServer();
    }

    private class SocketTask implements Runnable {

        private final int port;

        public java_21162_SocketServer_A03(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                // Create a server socket with SSL/TLS.
                serverSocket = (port == 443) ? (ServerSocket) sslServerSocketFactory.createServerSocket(port)
                        : (ServerSocket) sslServerSocketFactory.createServerSocket(port, 10000);
                while (true) {
                    // Wait for a client to connect.
                    Socket clientSocket = serverSocket.accept();
                    logger.log(Level.INFO, "Accepted connection from {0}.", clientSocket.getInetAddress().getHostAddress());

                    // Perform basic security operations related to Injection Attacks.
                    // Here we're just printing out the client's IP address.
                    InetAddress remoteAddress = clientSocket.getInetAddress();
                    logger.log(Level.INFO, "Client Remote Address: {0}", remoteAddress.getHostAddress());

                    // Send a hello message.
                    String message = "Hello, Client!";
                    clientSocket.getOutputStream().write(message.getBytes());
                    clientSocket.close();
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error in communication.", ex);
            } finally {
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException ex) {
                        logger.log(Level.SEVERE, "Error closing serverSocket.", ex);
                    }
                }
            }
        }
    }
}