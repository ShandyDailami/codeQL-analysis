import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33246_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                // Creating a new thread for each client connection
                new Thread(() -> handleRequest(clientSocket))
                        .start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while running the server. " + e.getMessage());
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle the request here using the socket
    }
}