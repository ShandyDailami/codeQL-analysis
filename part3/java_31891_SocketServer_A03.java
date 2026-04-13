import java.io.*;
import java.net.*;
import java.util.*;

public class java_31891_SocketServer_A03 {
    private static final int PORT = 1234;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            clients.add(writer);

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;

        public java_31891_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String message;

                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    for (PrintWriter writer : clients) {
                        writer.println(message);
                    }
                }

                clients.remove(client.getOutputStream());
                client.close();
            } catch (IOException e) {
                clients.remove(client.getOutputStream());
                client.close();
            }
        }
    }
}