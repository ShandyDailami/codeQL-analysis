import java.io.*;
import java.net.*;
import java.util.*;

public class java_13614_SocketServer_A07 {

    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected from " + client.getRemoteSocketAddress());
            clients.add(client);

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_13614_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                out.println("Hello, client!");

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    out.println("Server: " + input);
                }
            } catch (Exception e) {
                clients.remove(client);
                System.out.println("Client " + client.getRemoteSocketAddress() + " disconnected");
            }
        }
    }
}