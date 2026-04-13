import java.io.*;
import java.net.*;
import java.util.*;

public class java_35182_SocketServer_A07 {

    // A list of users for demonstration purposes
    private static List<String> users = new ArrayList<>();

    // The server socket
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        // Create a new server socket on port 12345
        server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            // Accept a new client connection
            Socket client = server.accept();
            System.out.println("Client connected from: " + client.getRemoteSocketAddress());

            // Create a new thread for handling the client connection
            new ClientHandler(client).start();
        }
    }

    // Handler for each client connection
    private static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_35182_SocketServer_A07(Socket s) {
            this.client = s;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                // Send a welcome message
                out.println("Welcome to the server!");

                // Listen for commands from the client
                String command;
                while ((command = in.readLine()) != null) {
                    // For simplicity, we'll just echo back commands
                    out.println("Server received: " + command);

                    // If the client wants to disconnect, close the connection
                    if (command.equals("disconnect")) {
                        close();
                    }
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                // Close the client connection
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                // Ignore errors
            }
        }
    }
}