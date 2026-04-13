import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35273_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        // Create server socket
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started at port " + PORT);

            while (true) {
                // Accept client socket
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException ex) {
            System.out.println("Error in server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Inner class for handling a client connection
    private static class ClientHandler extends Thread {
        private final Socket client;

        public java_35273_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    // Simple check for injection attempt
                    if (message.contains("injection")) {
                        System.out.println("Injection attempt detected in message from " + client.getRemoteSocketAddress());
                        writer.println("Injection attempt detected, please don't try to exploit it.");
                        writer.flush();
                    } else {
                        System.out.println("Received: " + message);
                        writer.println("Received: " + message);
                        writer.flush();
                    }
                }

                // Close the connection
                client.close();

            } catch (IOException ex) {
                System.out.println("Error in client handler: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}