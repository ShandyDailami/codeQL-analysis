import java.io.*;
import java.net.*;
import java.util.*;

public class java_03003_SocketServer_A07 {
    private static final int PORT = 1234;
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            ClientHandler clientHandler = new ClientHandler(client);
            clients.add(clientHandler);

            clientHandler.startCommunication();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_03003_SocketServer_A07(Socket client) {
            this.client = client;
            init();
        }

        private void init() {
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
                close();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // handle message here
                    for (ClientHandler client : clients) {
                        client.sendMessage("Server: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        public void close() {
            clients.remove(this);
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}