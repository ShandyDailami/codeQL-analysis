import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_26680_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());
    private static final int PORT = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            logger.log(Level.INFO, "Server started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                logger.log(Level.INFO, "Client connected from " + socket.getRemoteSocketAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error accepting client connection", ex);
            System.exit(-1);
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error closing server socket", ex);
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_26680_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client here
        }
    }
}