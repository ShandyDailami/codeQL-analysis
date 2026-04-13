import java.io.*;
import java.net.*;
import java.util.*;

public class java_25582_SocketServer_A07 {
    // A server socket for handling multiple clients
    private ServerSocket serverSocket;

    public java_25582_SocketServer_A07(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected on port " + clientSocket.getLocalPort());

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));

            // Start the new thread
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_25582_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Get the output stream from the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Create a buffer for reading client input
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Read a line of client input
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    // Check if the client is authenticated (e.g., by password)
                    if (isClientAuthenticated(inputLine)) {
                        // If so, send a response back to the client
                        out.println("Client authenticated successfully.");
                    } else {
                        // If not, send an error message back to the client
                        out.println("Client authentication failed.");
                    }
                }

                // Close the connection
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isClientAuthenticated(String input) {
            // This is a simple example of a client authentication mechanism.
            // In a real application, you would typically hash the password with a salt and check against the hashed value.
            // For the sake of simplicity, we'll just check if the input matches a hard-coded value.
            return input.equals("hardcodedPassword");
        }
    }

    public static void main(String[] args) throws IOException {
        // Start the server
        VanillaSocketServer server = new VanillaSocketServer(12345);
        server.startServer();
    }
}