import java.io.*;
import java.net.*;
import java.util.*;

public class java_22438_SocketServer_A07 {
    private ArrayList<ClientHandler> clients = new ArrayList<>();
    private ServerSocket serverSocket;

    public java_22438_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());
                ClientHandler handler = new ClientHandler(socket);
                clients.add(handler);
                handler.start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server(12345);
    }

    public class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_22438_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error setting up I/O for a client at " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform authentication here
                    if (authenticate(message)) {
                        // If authenticated, pass message to other clients
                        for (ClientHandler client : clients) {
                            if (client != this) {
                                client.sendMessage("Message from " + socket.getRemoteSocketAddress() + ": " + message);
                            }
                        }
                    } else {
                        // If not authenticated, close connection
                        socket.close();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client at " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }

        private boolean authenticate(String message) {
            // Implement authentication logic here
            // For now, just return true
            return true;
        }

        public void sendMessage(String message) {
            writer.println(message);
        }
    }
}