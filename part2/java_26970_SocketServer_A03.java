import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26970_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Spawn a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket client;

        public java_26970_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle client connection, etc.
            // ...
        }
    }
}