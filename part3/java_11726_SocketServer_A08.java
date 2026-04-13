import java.io.*;
import java.net.*;
import java.util.*;

public class java_11726_SocketServer_A08 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                clients.add(client);

                // Start a new thread to handle the client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_11726_SocketServer_A08(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Read a message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Check if the message is valid
                if (checkMessage(message)) {
                    System.out.println("Valid message, sending back to client");
                    out.writeUTF("Message received successfully");
                } else {
                    System.out.println("Invalid message, sending back to client");
                    out.writeUTF("Invalid message");
                }

                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean checkMessage(String message) {
            // Add your security checks here
            // This is a simple example, just check if the message is null or empty
            return message != null && !message.isEmpty();
        }
    }
}