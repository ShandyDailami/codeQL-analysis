import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19201_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is running and waiting for client connections on port " + PORT);

        // Accept a new client
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

        // Handle the client connection
        // This is a very basic example and may not be suitable for a real-world application
        String response = "Hello, Client!";
        clientSocket.getOutputStream().write(response.getBytes());

        // Close the client connection
        clientSocket.close();

        // Shutdown the server socket
        serverSocket.close();
    }
}