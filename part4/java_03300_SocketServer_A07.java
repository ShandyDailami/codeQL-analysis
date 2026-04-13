import java.io.*;
import java.net.*;
import java.util.*;

public class java_03300_SocketServer_A07 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("Client connected");
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_03300_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String clientMessage;
            while ((clientMessage = readMessage()) != null) {
                System.out.println("Received message: " + clientMessage);
                if (isAuthenticationFailed(clientMessage)) {
                    sendMessage("Authentication failed");
                    return;
                }
                sendMessage("Message received");
            }
        }

        private String readMessage() {
            try {
                return input.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void sendMessage(String message) {
            try {
                output.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isAuthenticationFailed(String message) {
            // Implement your authentication logic here
            // For now, we'll just return false
            return false;
        }
    }
}