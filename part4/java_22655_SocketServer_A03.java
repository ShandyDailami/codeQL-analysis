import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22655_SocketServer_A03 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        // Create a new server socket
        server = new ServerSocket(6789);

        // Create a new executor service
        executor = Executors.newCachedThreadPool();

        System.out.println("Server is running...");

        while (true) {
            try {
                // Accept a new client connection
                Socket client = server.accept();

                // Create a new thread for the client connection
                executor.execute(new ClientHandler(client));

            } catch (Exception ex) {
                ex.printStackTrace();
                continue;
            }
        }
    }

    // Inner class to handle client connection
    private static class ClientHandler implements Runnable {

        private Socket client;

        public java_22655_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                DataOutputStream writer = new DataOutputStream(client.getOutputStream());

                // Receive message from client
                String message = reader.readLine();

                // Process the message here if necessary
                // For example, print the message to the console
                System.out.println("Received: " + message);

                // Send a response back to the client
                writer.writeBytes("Server received your message\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}