import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12900_SocketServer_A01 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        // Create a ServerSocket that listens on port 9000
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Infinite loop to keep the server running until it's manually stopped
            while (true) {
                // Wait for a client to connect to the server
                Socket client = server.accept();

                // Create a new thread for handling the client connection
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Server could not start because of: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Handler for one client connection
    private static class ClientHandler extends Thread {
        private Socket client;

        public java_12900_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle the client connection here...
        }
    }
}