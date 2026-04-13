import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16151_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        // Create a server socket and wait for incoming connections
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();

                // Start a new thread to handle the client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT + ". Reason: " + e.getMessage());
        }
    }

    // Handles communication with a client
    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_16151_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle the client connection securely
            // This is a simplified example and not a secure implementation
            try {
                // Create input and output streams for communication
                // Use the socket's input and output streams for this
                // This is a security sensitive operation
                socket.getInputStream().read();
            } catch (IOException e) {
                System.err.println("Failed to read from socket. Reason: " + e.getMessage());
            }
        }
    }
}