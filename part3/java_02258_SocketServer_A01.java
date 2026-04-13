import java.io.*;
import java.net.*;
import java.util.*;

public class java_02258_SocketServer_A01 {
    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

                clients.add(client);

                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Exception occured when trying to listen on port " + PORT);
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

    private static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_02258_SocketServer_A01(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                close(client, in, out);
                clients.remove(client);
                System.out.println("Exception occurred when setting up communication with client " + client.getRemoteSocketAddress());
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    sendToAll("Message from client: " + message);
                }
            } catch (IOException e) {
                close(client, in, out);
                clients.remove(client);
                System.out.println("Exception occurred when handling communication with client " + client.getRemoteSocketAddress());
            }
        }

        private void sendToAll(String message) {
            for (Socket client : clients) {
                try {
                    out.println(message);
                    out.flush();
                } catch (IOException e) {
                    close(client, in, out);
                    clients.remove(client);
                    System.out.println("Exception occurred when sending message to client " + client.getRemoteSocketAddress());
                }
            }
        }

        private void close(Socket client, BufferedReader in, PrintWriter out) {
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}