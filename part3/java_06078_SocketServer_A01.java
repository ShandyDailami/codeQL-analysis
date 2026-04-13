import java.io.*;
import java.net.*;
import java.util.*;

public class java_06078_SocketServer_A01 {
    private static List<Socket> clientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            clientList.add(client);

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_06078_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // If the message is "quit", break the loop
                    if (message.equals("quit")) break;

                    // Encrypt and send the message back to the client
                    String encryptedMessage = encryptMessage(message);
                    out.println(encryptedMessage);
                }

                client.close();
                clientList.remove(client);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String encryptMessage(String message) {
            // Simple encryption here: replace each character by its ASCII value
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                encryptedMessage.append((int) c);
            }
            return encryptedMessage.toString();
        }
    }
}