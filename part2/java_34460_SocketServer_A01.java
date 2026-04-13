import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34460_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Here we're allowing for the creation of new threads for each client
                // This is a demonstration of security-sensitive operations, not recommended in a real-world application
                new Thread(() -> handleClient(clientSocket))
                    .start();
            }
        } catch (IOException e) {
            System.out.println("Error while setting up the server: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Server handling code here
        // This is a demonstration of security-sensitive operations, not recommended in a real-world application
        try {
            // ...
        } catch (IOException e) {
            System.out.println("Error while handling the client: " + e.getMessage());
        }
    }
}