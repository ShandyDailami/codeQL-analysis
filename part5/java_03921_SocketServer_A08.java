import java.io.*;
import java.net.*;
import java.util.*;

public class java_03921_SocketServer_A08 {

    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Add client socket to list of clients
                clients.add(clientSocket);

                // Create new thread for client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_03921_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error in client handler: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    // Broadcast message to all clients
                    for (Socket socket : clients) {
                        out = new PrintWriter(socket.getOutputStream(), true);
                        out.println(clientMessage);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error in client handler: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}