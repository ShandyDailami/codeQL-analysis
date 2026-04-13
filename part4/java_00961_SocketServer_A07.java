import java.io.*;
import java.net.*;
import java.util.*;

public class java_00961_SocketServer_A07 {
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected...");

            ClientHandler clientHandler = new ClientHandler(client);
            clients.add(clientHandler);

            clientHandler.start();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_00961_SocketServer_A07(Socket client) {
            this.client = client;

            try {
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                writer = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                for (ClientHandler client : clients) {
                    if (!client.equals(this) && client.isConnected()) {
                        client.sendMessage("Message from " + this + ": " + message);
                    }
                }
            }
            closeConnection();
        }

        private String readMessage() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                closeConnection();
            }
            return null;
        }

        private void sendMessage(String message) {
            writer.println(message);
        }

        private void closeConnection() {
            clients.remove(this);
            try {
                reader.close();
                writer.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return client.getInetAddress().getHostAddress();
        }
    }
}