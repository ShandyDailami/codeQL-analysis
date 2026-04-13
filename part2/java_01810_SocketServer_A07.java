import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_01810_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT, 0, InetAddress.getByName("localhost"))) {

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                LOGGER.log(Level.INFO, "New connection accepted from {0}", clientSocket.getRemoteSocketAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to establish a new connection.", ex);
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_01810_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle the client's request and response here
        }
    }
}