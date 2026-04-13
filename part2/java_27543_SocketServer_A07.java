import java.io.*;
import java.net.*;
import java.util.*;

public class java_27543_SocketServer_A07 {
    // Create a list to hold all connected clients
    static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(6000);

            System.out.println("Server is listening on port 6000...");

            while (true) {
                // Accept a new client socket
                Socket clientSocket = serverSocket.accept();

                // Add the client socket to the list of connected clients
                clientSockets.add(clientSocket);

                // Create a new thread for each connected client
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Thread for each client
    static class ClientHandler implements Runnable {
        Socket clientSocket;

        public java_27543_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Receive a message from the client
                String message = in.readUTF();

                // Perform security-sensitive operation (e.g., authentication)
                if (authenticateClient(message)) {
                    // If authentication is successful, send a response back to the client
                    out.writeUTF("Authentication successful.");
                } else {
                    // If authentication fails, send a response back to the client
                    out.writeUTF("Authentication failed.");
                }

                // Close the connection
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Simulate the authentication process
        private boolean authenticateClient(String message) {
            // This is a simple example where we just check if the message is "client"
            return message.equals("client");
        }
    }
}