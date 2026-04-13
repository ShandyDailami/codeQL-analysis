import java.io.*;
import java.net.*;
import java.util.*;

public class java_38456_SocketServer_A03 {

    private static List<Socket> clients = new ArrayList<>();
    private static ServerSocket server;
    private static boolean running = true;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(5000);
            System.out.println("Server started.");

            while (running) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("New client connected.");

                new Handler(client).start();
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_38456_SocketServer_A03(Socket client) {
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
            String message;

            while ((message = in.readUTF()) != null) {
                System.out.println("Received: " + message);
                // You can replace the following line with your own security-sensitive operation
                // For example, you could encode the message before sending it
                try {
                    out.writeUTF(message.toUpperCase());
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            clients.remove(client);
            client.close();
            System.out.println("Client disconnected.");
        }
    }
}