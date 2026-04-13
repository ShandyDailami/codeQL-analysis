import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24437_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 12345; // Choose a port

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to start due to " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;

    public java_24437_SocketServer_A01(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Handle client here
            // This is a placeholder and will not actually work due to security concerns
            // You would need to implement authentication, encrypt communication, and other secure operations
            System.out.println("Client handler for " + client.getRemoteSocketAddress() + " started");
        } catch (IOException e) {
            System.err.println("Failed to handle client " + client.getRemoteSocketAddress() + " due to " + e.getMessage());
        }
    }
}