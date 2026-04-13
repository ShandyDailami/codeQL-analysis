import java.io.*;
import java.net.*;
import java.util.*;

public class java_16952_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(54321);
            System.out.println("Server started");

            while (true) {
                Socket client = server.accept();
                clients.add(client);

                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Handle the client in a new thread
                Thread t = new Thread(new ClientHandler(client));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        Socket client;

        public java_16952_SocketServer_A03(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Check for injection attempts
                    if (message.contains("inject")) {
                        // If injection attempt, echo back the message
                        out.println("Injection attempt detected. Echoing back message.");
                        out.println(message);

                        // Echo back the original message
                        out.println(message);
                    } else {
                        // If not an injection attempt, simply send the message
                        out.println(message);
                    }
                }

                // Remove the client from the list
                clients.remove(client);
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}