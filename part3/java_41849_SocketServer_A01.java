import java.io.*;
import java.net.*;
import java.util.*;

public class java_41849_SocketServer_A01 {
    private static final int PORT = 6789;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());
            clients.add(client);

            new ClientHandler(client).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket client;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_41849_SocketServer_A01(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                client.close();
                clients.remove(client);
                System.out.println("Client disconnected.");
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Security-sensitive operation related to A01_BrokenAccessControl
                    // Here we are only forwarding the received message to all other clients
                    for (Socket sock : clients) {
                        try {
                            out.writeUTF(message);
                            out.flush();
                        } catch (IOException e) {
                            sock.close();
                            clients.remove(sock);
                            System.out.println("Client disconnected.");
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            }
        }
    }
}