import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_40677_SocketServer_A01 {

    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());
    
    private static final int PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT);
            logger.log(Level.INFO, "Server started on port: {0}", PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Server failed to start", ex);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class ClientHandler extends Thread {

        private Socket clientSocket;

        public java_40677_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
            start();
        }

        @Override
        public void run() {
            // Place your security-sensitive operations here
            // For example, we'll ensure that only the client can read from the socket
            try {
                while ((clientSocket.getInputStream()).read() != -1) {
                    // no-op
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Client failed to close", ex);
            }
        }
    }
}