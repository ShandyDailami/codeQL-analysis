import java.io.*;
import java.net.*;
import java.util.*;

public class java_20914_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket client = server.accept();
            clients.add(client);
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket client;

        public java_20914_SocketServer_A08(Socket client) {
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
                    // Assume we want to send back the same message to the client
                    writer.println(message);
                }

                client.close();
                clients.remove(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}