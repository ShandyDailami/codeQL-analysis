import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32563_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        // Create a new ServerSocket with the specified port number.
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running and waiting for client connections...");

            // Accept incoming client connections and establish a new socket for communication
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket client;

    public java_32563_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle communication with the client here
        // ...
    }
}