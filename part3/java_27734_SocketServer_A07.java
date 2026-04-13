import java.io.*;
import java.net.*;

public class java_27734_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Start a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_27734_SocketServer_A07(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Read the username from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            // Read the username from the client
            String username = in.readUTF();
            System.out.println("Username: " + username);

            // Check if the username is valid (e.g., not null or empty, etc.)
            if (isValidUsername(username)) {
                // If valid, send a success message back to the client
                out.writeUTF("Success!");
            } else {
                // If not valid, send an error message back to the client
                out.writeUTF("Error: Invalid username!");
            }

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }

    private boolean isValidUsername(String username) {
        // Implement your security-sensitive operation here
        // This is just a placeholder for now
        // You should replace this with your actual implementation
        return !(username == null || username.trim().isEmpty());
    }
}