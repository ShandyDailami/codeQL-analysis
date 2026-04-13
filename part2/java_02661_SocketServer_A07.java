import java.io.*;
import java.net.*;
import java.util.*;

public class java_02661_SocketServer_A07 {
    // Global variable to hold the list of clients
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        // Create a server socket and listen for incoming connections
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                // Add the new client to the list
                clients.add(client);

                // Start a new thread to handle this client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This class represents a handler for a single client connection
    private static class ClientHandler extends Thread {
        private Socket client;

        public java_02661_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);

                    // Forward the message to all other clients
                    for (Socket socket : clients) {
                        try (OutputStream out = socket.getOutputStream()) {
                            out.write((message + "\n").getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}