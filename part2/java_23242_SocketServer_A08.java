import java.io.*;
import java.net.*;

public class java_23242_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Set up the server
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a new thread for the client
            new ClientHandler(client).start();
        }
    }

    static class ClientHandler extends Thread {
        Socket client;
        BufferedReader in;
        PrintWriter out;

        public java_23242_SocketServer_A08(Socket s) {
            this.client = s;
            try {
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out = new PrintWriter(s.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error setting up I/O for a client");
            }
        }

        public void run() {
            try {
                // Send a welcome message to the client
                out.println("Welcome to the server! Your ID is " + client.getPort());

                String message;
                while ((message = in.readLine()) != null) {
                    // Process the incoming message
                    System.out.println("Received: " + message);

                    // Send a response back to the client
                    out.println("Echo: " + message);
                }

                // Close the connection
                out.close();
                in.close();
                client.close();
            } catch (IOException e) {
                System.out.println("Error handling client");
            }
        }
    }
}