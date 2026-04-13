import java.io.*;
import java.net.*;
import java.util.*;

public class java_06272_SocketServer_A03 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from: " + client.getRemoteSocketAddress());

            clients.add(client);

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_06272_SocketServer_A03(Socket client) {
            this.clientSocket = client;
            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                clients.remove(client);
                close(in);
                close(out);
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                if (message.contains("injection")) {
                    message = sanitizeInput(message);
                }
                sendMessage("Server: " + message);
            }
            clients.remove(clientSocket);
        }

        private String readMessage() {
            try {
                return in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void sendMessage(String message) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String sanitizeInput(String input) {
            // Implement your own sanitization logic here.
            // This is just a placeholder.
            return input;
        }

        private void close(Closeable stream) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}