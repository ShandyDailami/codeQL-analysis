import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04088_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Connected with " + client.getRemoteSocketAddress());

                // Handle client in a new thread
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while starting server: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket client;

    public java_04088_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Handle client in a new thread
            new Thread(new ClientHandler(client)).start();

            // Here is the security sensitive operation related to A01_BrokenAccessControl
            // This operation is not possible here because we are using a standard library and 
            // cannot perform operations that require access control.

        } catch (IOException e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
        }
    }
}