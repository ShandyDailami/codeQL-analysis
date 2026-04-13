import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00421_SocketServer_A07 {

    private static final int PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        // Create server socket
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client connection in a new thread
                HandleClient clientHandler = new HandleClient(clientSocket);
                clientHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}