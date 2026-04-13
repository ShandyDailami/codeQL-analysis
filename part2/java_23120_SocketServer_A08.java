import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_23120_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    private static final int PORT = 8080;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            logger.log(Level.INFO, "Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception occurred while starting the server", ex);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "Exception occurred while closing the server", ex);
                }
            }
        }
    }

    private static class SocketHandler implements Runnable {

        private Socket socket;

        public java_23120_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // perform your security sensitive operations here

                // for example, let's verify the integrity of the socket connection
                if (!socket.getInetAddress().equals(socket.getLocalAddress())) {
                    logger.log(Level.WARNING, "IntegrityFailure: Connection from {0} is not being used", socket.getInetAddress());
                    // You can decide to do something here like closing the connection or notifying the user.
                }

            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Exception occurred while handling the socket", ex);
            }
        }
    }
}