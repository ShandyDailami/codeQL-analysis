import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10997_SocketServer_A03 {
    private int port;

    public java_10997_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Connected client: " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                new Thread(() -> handleClient(client)).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server on port " + port);
            e.printStackTrace();
        }
    }

    private void handleClient(Socket client) {
        // Handle client communication here. This is a very basic example and does not include security-related operations like A03_Injection
        // You would replace this with your own logic for handling client requests
        try {
            // Read request from client
            // ...

            // Write response to client
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080; // Default port

        // Check if port is provided as command line argument
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new SecureSocketServer(port).start();
    }
}