import java.io.*;
import java.net.*;
import java.util.*;

public class java_15410_SocketServer_A08 {

    // A list to keep track of active connections
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8181);
        System.out.println("Server started at port 8181");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // Add client socket to the list
            clients.add(client);

            // Create a new thread for each client
            new ClientHandler(client).start();
        }
    }

    // ClientHandler class
    private static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_15410_SocketServer_A08(Socket client) {
            this.client = client;
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
                out.println("Welcome to the server! You are connected to port 8181.");

                // Receive and send messages
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate integrity failure
                    if (message.equals("FAIL")) {
                        throw new RuntimeException("Integrity failure");
                    }

                    // Send the message back to the client
                    out.println("Sent: " + message);
                }

                // Close the connection
                close();
            } catch (IOException e) {
                System.out.println("Client disconnected");
            } catch (RuntimeException e) {
                System.out.println("Handling integrity failure: " + e.getMessage());
            }
        }

        private void close() {
            clients.remove(client);
            client.close();
            in.close();
            out.close();
            System.out.println("Connection closed");
        }
    }
}