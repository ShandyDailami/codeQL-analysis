import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15468_SocketServer_A08 {

    private static final int PORT = 1234; // port to listen to

    public static void main(String[] args) {
        System.out.println("Starting server...");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for connection...");

                Socket client = server.accept();
                System.out.println("Connected with " + client.getRemoteSocketAddress());

                // create new thread for each client connection
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private final Socket client;

    public java_15468_SocketServer_A08(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // handle client request here
        try {
            // TODO: Implement client request handling here.
            // For example, read the request from the client and then send a response.
            // The actual implementation of this is not provided here.
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                System.out.println("Error closing client: " + e.getMessage());
            }
        }
    }
}