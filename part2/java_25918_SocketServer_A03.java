import java.io.*;
import java.net.*;
import java.util.*;

public class java_25918_SocketServer_A03 {
    private static boolean running = true;
    private static ServerSocket server;
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            server = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (running) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
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

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_25918_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream input = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Echo back the message
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(client);
                System.out.println("Client disconnected from " + client.getRemoteSocketAddress());
            }
        }
    }
}