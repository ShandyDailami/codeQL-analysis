import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26297_SocketServer_A01 {
    private static final int PORT = 12345; // Change this value to the port you want the server to listen on.

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected");

                // Send welcome message to client
                String welcomeMessage = "Welcome to the server!";
                clientSocket.getOutputStream().write(welcomeMessage.getBytes());

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT + ": " + e.getMessage());
        }
    }
}