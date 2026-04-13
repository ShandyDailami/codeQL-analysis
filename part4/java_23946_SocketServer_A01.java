import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_23946_SocketServer_A01 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        int port = 8080;

        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            LOGGER.log(Level.INFO, "Server started on port: " + port);

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                if (clientSocketChannel != null) {
                    LOGGER.log(Level.INFO, "New client connected from: " + clientSocketChannel.socket().getRemoteSocketAddress());

                    // Start a new thread to handle the communication
                    new HandleClientTask(clientSocketChannel).start();
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "I/O exception occurred: " + ex.getMessage(), ex);
        } finally {
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Error closing server socket: " + ex.getMessage(), ex);
                }
            }
        }
    }

    private static class HandleClientTask extends Thread {
        private SocketChannel clientSocketChannel;

        public java_23946_SocketServer_A01(SocketChannel clientSocketChannel) {
            this.clientSocketChannel = clientSocketChannel;
        }

        @Override
        public void run() {
            // Handle the communication with the client here
            // ...
        }
    }
}