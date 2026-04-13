import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28836_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations here
                // e.g., check if the client's IP address is whitelisted
                // If not, deny connection

                // Create a new thread for the client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket client;

        public java_28836_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Perform client-specific operations here
            // e.g., handle incoming messages
        }
    }
}