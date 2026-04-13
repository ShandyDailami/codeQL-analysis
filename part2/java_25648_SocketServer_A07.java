import java.io.*;
import java.net.*;

public class java_25648_SocketServer_A07 {
    private static int port = 8080;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Start a new thread to handle communication with the client
                Thread t = new Thread(new ClientHandler(client, in, out));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("IOException in server: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_25648_SocketServer_A07(Socket client, DataInputStream in, DataOutputStream out) {
            this.client = client;
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                // Receive the username from the client
                String username = in.readUTF();
                System.out.println("Received username: " + username);

                // Send a welcome message back to the client
                out.writeUTF("Hello, " + username + "!");
                out.flush();

                // Start a new thread for communication with the client
                Thread t = new Thread(new ClientHandler(client, in, out));
                t.start();
            } catch (IOException e) {
                System.out.println("IOException in client handler: " + e.getMessage());
            }
        }
    }
}