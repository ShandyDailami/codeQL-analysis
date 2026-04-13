import java.io.*;
import java.net.*;
import java.util.*;

public class java_30271_SocketServer_A01 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started at port 8189");

            while (true) {
                Socket client = server.accept();
                clients.add(client);

                System.out.println("Client connected from IP: " + client.getInetAddress().getHostAddress());

                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_30271_SocketServer_A01(Socket client) {
            this.client = client;

            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;

                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);

                    // Modify the message here for security-sensitive operations related to A01_BrokenAccessControl
                    message = "Modified message: " + message;

                    for (Socket client : clients) {
                        out = new DataOutputStream(client.getOutputStream());
                        out.writeUTF(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}