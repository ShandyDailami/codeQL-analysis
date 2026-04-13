import java.io.*;
import java.net.*;
import java.util.*;

public class java_10138_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) throws Exception {
        server = new ServerSocket(5000);
        System.out.println("Server started");

        while (true) {
            Socket client = server.accept();
            clients.add(client);
            System.out.println("Client connected");

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket client;

        public java_10138_SocketServer_A08(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Checking if client is attempting to break the integrity of the server
                    if (message.equals("BREAK_INTEGRITY")) {
                        writer.println("INTEGRITY_FAILURE");
                        writer.flush();
                        System.out.println("Client integrity check failure");
                        client.close();
                        clients.remove(client);
                        break;
                    }

                    // If no integrity failure, simply send the message back to client
                    writer.println(message);
                    writer.flush();
                }

                client.close();
                clients.remove(client);
            } catch (Exception e) {
                System.out.println("Error in client handler");
                e.printStackTrace();
            }
        }
    }
}