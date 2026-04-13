import java.io.*;
import java.net.*;
import java.util.*;

public class java_00566_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            server = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            while (true) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());

                // handle the client connection
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        Socket client;

        public java_00566_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // read data from client
                DataInputStream in = new DataInputStream(client.getInputStream());
                String message = in.readUTF();

                // process the message
                message = processMessage(message);

                // send processed data to client
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(message);

                // close connection
                client.close();
                clients.remove(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processMessage(String message) {
            // simple injection check
            if (message.contains("injection")) {
                return "Error: Injection detected";
            } else {
                return "Processed message: " + message;
            }
        }
    }
}