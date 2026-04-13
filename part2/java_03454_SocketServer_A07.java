import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_03454_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());
    private static final int PORT = 12345;

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setReuseAddress(true);

            LOGGER.info("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.info("Client connected: " + socket.getRemoteSocketAddress());

                InetAddress clientAddress = socket.getInetAddress();
                LOGGER.info("Client IP: " + clientAddress.getHostAddress());

                // Add handshake here to secure the connection

                // Start new thread to handle client
                new ClientHandler(socket).start();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Server failed.", ex);
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_03454_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Add your client-specific code here
        }
    }
}