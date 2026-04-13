import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15705_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Perform authentication here (e.g., via SSL)
                // Assume that the client is authenticated successfully
                boolean isAuthenticated = true;

                if (isAuthenticated) {
                    // Pass client socket to a new thread for processing
                    new ClientHandler(clientSocket).start();
                } else {
                    System.out.println("Authentication failed. Closing connection.");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_15705_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client connection here
            // (e.g., via socket I/O)
        }
    }
}