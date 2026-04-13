import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16820_SocketServer_A03 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        // Start the server
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port " + PORT + ". Error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket client;

    public java_16820_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle client communication here
        // ...
    }
}