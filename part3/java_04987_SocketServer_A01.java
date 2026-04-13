import java.io.*;
import java.net.*;
import java.util.*;

public class java_04987_SocketServer_A01 {

    // Create an array of threads.
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().startServer();
    }

    // Start server.
    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client.
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException ex) {
            System.out.println("Error in server!");
            ex.printStackTrace();
        }
    }

    // Thread to handle multiple client requests.
    public class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_04987_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Error getting input/output streams!");
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                // Read the message from the client.
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Broadcast the message to all clients.
                    broadcastMessage("Client says: " + message);
                }
            } catch (IOException ex) {
                System.out.println("Error reading from client!");
                ex.printStackTrace();
            }
        }

        // Send a message to all clients.
        public void broadcastMessage(String message) {
            for (ClientHandler client : clients) {
                client.sendMessage(message);
            }
        }

        // Send a message to a specific client.
        public void sendMessage(String message) {
            out.println(message);
        }
    }
}