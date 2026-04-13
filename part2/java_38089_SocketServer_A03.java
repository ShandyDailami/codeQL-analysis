import java.io.*;
import java.net.*;
import java.util.*;

public class java_38089_SocketServer_A03 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    private static ServerSocket server;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try {
            // Create the server socket
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started at port " + SERVER_PORT);

            while (true) {
                // Accept a new client
                Socket client = server.accept();
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_38089_SocketServer_A03(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Send a welcome message to the client
                out.println("Welcome!");

                // Receive data from the client and send back a response
                String input;
                while ((input = in.readLine()) != null) {
                    out.println("Echo: " + input);
                }

                // Close the connection
                out.close();
                in.close();
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}