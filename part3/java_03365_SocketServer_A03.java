import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_03365_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    private static final String CLIENT_IP = "127.0.0.1";

    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(CLIENT_IP);
        } catch (IOException e1) {
            LOGGER.log(Level.SEVERE, "Failed to get address by name", e1);
            System.exit(1);
        }

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT, address)) {
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                Socket socket = sslServerSocket.accept();
                LOGGER.info("Accepted connection from " + socket.getRemoteSocketAddress());

                // Create a new thread for each connection
                new HandleConnection(socket).start();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to create or start server socket", e);
        }
    }

    private static class HandleConnection extends Thread {
        private Socket socket;

        public java_03365_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle the socket connection here
        }
    }
}