import java.io.*;
import java.net.*;

public class java_13854_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444); // Listening on port 4444
        System.out.println("Server is running and waiting for connections...");

        while (true) {
            Socket client = server.accept(); // Accept a new client connection
            System.out.println("Client connected from: " + client.getRemoteSocketAddress());

            // Create new threads for handling each client
            new HandlerThread(client).start();
        }
    }

    // Inner class for handling client communication
    static class HandlerThread extends Thread {
        Socket client;

        HandlerThread(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) { // Read message from client
                    System.out.println("Received: " + message);
                    out.println("Thank you for connecting: " + message); // Echo back received message
                }

                client.close(); // Close connection
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}