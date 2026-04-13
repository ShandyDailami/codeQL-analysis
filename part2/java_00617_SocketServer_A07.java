import java.io.*;
import java.net.*;
import java.util.*;

public class java_00617_SocketServer_A07 {
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                ClientHandler clientHandler = new ClientHandler(client);
                clients.add(clientHandler);

                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_00617_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);
                    // Authentication related operations go here
                    // Example: check if client is authenticated
                    if (clientMessage.startsWith("auth ")) {
                        String username = clientMessage.substring(5);
                        // Assume authentication is successful if the username is correct
                        if ("valid_user".equals(username)) {
                            writer.println("Auth successful");
                        } else {
                            writer.println("Auth failed");
                        }
                    } else {
                        writer.println("Invalid command");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}