import java.io.*;
import java.net.*;
import java.util.*;

public class java_26841_SocketServer_A07 {

    // List of connected clients
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(6666);

        while (true) {
            System.out.println("Waiting for a client...");
            Socket socket = server.accept();
            clients.add(socket);

            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Send a welcome message to the connected client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Welcome to the server!");

            // Start a new thread to handle communication with the client
            new Handler(socket).start();
        }
    }

    // Handler for each client
    private static class Handler extends Thread {

        private DataInputStream in;
        private DataOutputStream out;

        public java_26841_SocketServer_A07(Socket socket) {
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                while (true) {
                    // Receive a message from the client
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Broadcast the message to all clients
                    for (Socket socket : clients) {
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF(message);
                    }
                }
            } catch (Exception e) {
                clients.remove(this);
                socket.close();
            }
        }
    }
}