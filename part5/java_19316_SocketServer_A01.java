import java.io.*;
import java.net.*;
import java.util.*;

public class java_19316_SocketServer_A01 {

    // The list of clients connected to the server.
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started!");

        while (true) {
            // Accept a new client
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected!");

            // Add the new client socket to the list
            clientSockets.add(clientSocket);

            // Start a new thread to handle the client
            new ClientHandler(clientSocket).start();
        }
    }

    // A handler for a single client.
    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_19316_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                // Get the input and output streams
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Error getting input/output streams.");
                clientSocket.close();
            }
        }

        public void run() {
            try {
                // Send a welcome message
                out.writeUTF("Welcome to the server!");

                // Read and respond to client messages
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Respond to the client
                    out.writeUTF("Server response: " + message);
                    out.flush();
                }
            } catch (IOException e) {
                System.out.println("Error reading from client.");
                clientSocket.close();
            }
        }
    }
}