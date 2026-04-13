import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class java_08087_SocketServer_A07 {
    private static final int PORT = 5000;
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        runServer();
    }

    public static void runServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                clients.add(client);

                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;

        public java_08087_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Here you can add your security-sensitive operations
                // For instance, you can encrypt and decrypt data using AES
                // Here's a basic example:

                // Assume you get the input from the client
                // byte[] input = ...

                // Then, you can encrypt the input
                // byte[] encrypted = ...

                // Then, you can send the encrypted input to the client
                // client.getOutputStream().write(encrypted);

                // Similarly, you can decrypt the received data
                // byte[] decrypted = ...

                // The following code is just for demonstration,
                // and doesn't include the encryption/decryption logic.

                // Assume the received data is a simple text message
                // String message = new String(input, "UTF-8");

                // Then, you can print the received message
                // System.out.println("Received: " + message);
            } catch (IOException e) {
                System.out.println("Error in client handler: " + e.getMessage());
            }
        }
    }
}