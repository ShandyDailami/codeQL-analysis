import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23583_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT + ". Maybe another instance is running?");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket client;

    public java_23583_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle client's request
        try {
            // Send a response
            client.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the connection
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}