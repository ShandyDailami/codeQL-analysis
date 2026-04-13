import java.io.*;
import java.net.*;
import java.util.*;

public class java_01056_SocketServer_A08 {

    // Server's port number
    private static final int SERVER_PORT = 4445;

    // List of clients
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        // Create server socket
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                // Accept new client
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Add client socket to list
                clients.add(clientSocket);

                // Start new thread for client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Client handler
    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_01056_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            try {
                // Initialize streams
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                // Handle client messages
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Encrypt message
                    String encryptedMessage = encryptMessage(message);

                    // Send encrypted message to all clients
                    for (Socket client : clients) {
                        out.writeUTF(encryptedMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Simple encryption function
        private String encryptMessage(String message) {
            return new StringBuilder(message).reverse().toString();
        }
    }
}