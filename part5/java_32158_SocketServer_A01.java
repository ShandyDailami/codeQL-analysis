import java.io.*;
import java.net.*;
import java.util.*;

public class java_32158_SocketServer_A01 {
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port: " + serverSocket.getLocalPort());

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client: " + ex.getMessage());
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_32158_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Error setting up streams: " + ex.getMessage());
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Encrypt and send message
                    String encryptedMessage = encrypt(message);
                    out.writeUTF(encryptedMessage);
                }
            } catch (IOException ex) {
                System.out.println("Error handling client: " + ex.getMessage());
            }
        }

        private String encrypt(String message) {
            // Basic encryption: replace all characters with their ASCII value
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                encryptedMessage.append((int) c);
            }
            return encryptedMessage.toString();
        }
    }
}