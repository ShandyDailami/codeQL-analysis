import java.io.*;
import java.net.*;

public class java_15566_SocketServer_A08 {

    // Server socket
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        // Initialize server port
        int port = 8080;

        // Initialize server socket
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();

                // Create data input stream
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());

                // Handle client connection
                handleClient(clientSocket, input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket, DataInputStream input) {
        // Read client message
        try {
            String clientMsg = input.readUTF();

            // Process client message
            processClientMessage(clientMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processClientMessage(String clientMsg) {
        // Add your security sensitive operations here
        // For example: verify client's identity

        // Remove this comment and add your security sensitive operations.
        // ...
    }
}