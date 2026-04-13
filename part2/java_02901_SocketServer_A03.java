import java.io.*;
import java.net.*;
import java.util.*;

public class java_02901_SocketServer_A03 {
    private static final String SERVER_STATUS = "Server started successfully";
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(4444);
            System.out.println("Waiting for clients...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());
                clients.add(socket);
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_02901_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Client disconnected!");
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = input.readUTF();
                    System.out.println("Received: " + message);
                    // Here you can implement your security-sensitive operations related to A03_Injection

                    for (Socket client : clients) {
                        output = new DataOutputStream(client.getOutputStream());
                        output.writeUTF(message);
                    }
                }
            } catch (IOException ex) {
                clients.remove(socket);
                System.out.println("Client disconnected!");
            }
        }
    }
}