import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18983_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
       
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_18983_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Perform authentication here
            // This is a very basic authentication example
            if (authenticate()) {
                // If authentication is successful, then continue with the connection
                handleConnection();
            } else {
                // If authentication fails, close the connection
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Failed to close socket: " + e.getMessage());
                }
            }
        }

        // This is a very basic authentication example
        private boolean authenticate() {
            // Implement your own authentication logic here
            return true;
        }

        // This is a very basic handleConnection example
        private void handleConnection() {
            // Implement your own connection handling logic here
        }
    }
}