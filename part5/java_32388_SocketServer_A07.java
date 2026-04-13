import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32388_SocketServer_A07 {

    public static void main(String[] args) {
        // Create a new server socket and bind it to a port.
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080.");

            // Infinite loop to accept incoming client connections.
            while (true) {
                // Accept a new client connection.
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                    // Create a new thread to handle communication with the client.
                    new ClientHandler(clientSocket).start();
                }
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}