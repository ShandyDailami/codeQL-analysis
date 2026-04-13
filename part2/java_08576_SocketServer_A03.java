import java.io.*;
import java.net.*;
import java.util.*;

public class java_08576_SocketServer_A03 {

    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            try {
                Socket clientSocket = server.accept();
                System.out.println("Client connected...");

                clients.add(clientSocket);

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            } catch (IOException e) {
                System.out.println("Error during client connection...");
                e.printStackTrace();
            }
        }
    }

    public static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_08576_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                System.out.println("Received message: " + message);

                // Here, we're assuming that the client is sending plain text.
                // In a real-world scenario, you'd want to handle different types of messages.
                if (message.equals("quit")) {
                    sendMessage("Disconnected...");
                    clients.remove(clientSocket);
                    clientSocket.close();
                    break;
                }

                sendMessage("Hello, client!");
            }
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
    }
}