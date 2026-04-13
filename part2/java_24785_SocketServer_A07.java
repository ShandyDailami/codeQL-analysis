import java.io.*;
import java.net.*;
import java.util.*;

public class java_24785_SocketServer_A07 {

    private static final int port = 5678;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client " + client.getRemoteSocketAddress() + " connected.");

            clients.add(client);

            handleClient(client);
        }
    }

    private static void handleClient(Socket client) {
        try {
            OutputStream out = client.getOutputStream();
            out.write(("Hello client, you connected successfully.\n").getBytes());
            out.flush();

            Thread t = new Thread(new ClientHandler(client));
            t.start();
        } catch (IOException e) {
            clients.remove(client);
            System.out.println("Client " + client.getRemoteSocketAddress() + " disconnected.");
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_24785_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream in = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client says: " + message);

                    // Here you can perform your security sensitive operations related to A07_AuthFailure
                    // For example, checking if the message contains a password or a token
                    // If the message contains such information, you can reject the client

                    // To simulate an error, we'll just close the connection
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            clients.remove(client);
            System.out.println("Client " + client.getRemoteSocketAddress() + " disconnected.");
        }
    }
}