import java.io.*;
import java.net.*;
import java.util.*;

public class java_13408_SocketServer_A08 {
    private static final int port = 8080;
    private static int clientCounter = 0;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Server is running on port: " + port);

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = server.accept();
                System.out.println("Client accepted.");

                ClientHandler client = new ClientHandler(socket, this);
                clients.add(client);
                client.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public synchronized void closeClient(ClientHandler client) {
        clients.remove(client);
        System.out.println("Client disconnected.");
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private SocketServer server;
        private DataInputStream in;
        private DataOutputStream out;

        public java_13408_SocketServer_A08(Socket socket, SocketServer server) {
            this.socket = socket;
            this.server = server;

            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                System.out.println("Received message: " + message);
                server.broadcast(message);
            }
        }

        public String readMessage() {
            try {
                return in.readUTF();
            } catch (IOException e) {
                server.closeClient(this);
                return null;
            }
        }

        public void sendMessage(String message) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                server.closeClient(this);
            }
        }
    }
}