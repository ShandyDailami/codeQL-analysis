import java.io.*;
import java.net.*;

public class java_07216_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 12345;

        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create a new thread for the client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handler for a single client
    static class ClientHandler extends Thread {
        Socket client;

        public java_07216_SocketServer_A03(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Get input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Send a greeting message
                out.println("Hello client, I am a server! How can I assist you today?");

                // Close the connection
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}