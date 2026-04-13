import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33060_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        // Initialize executor service with a pool of threads
        executor = Executors.newCachedThreadPool();

        // Create server socket
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            try {
                // Accept a client connection
                Socket client = server.accept();

                // Spawn a new thread to handle communication with the client
                executor.execute(new ClientHandler(client));
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_33060_SocketServer_A03(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read message from client
                String message = in.readLine();

                // Process the message (e.g., print it)
                System.out.println("Received: " + message);

                // Send back a response
                out.writeBytes("Message received\n");

                client.close();
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }
        }
    }
}