import java.io.*;
import java.net.*;
import java.util.*;

public class java_11716_SocketServer_A07 {
    private static final String SERVER_NAME = "VanillaSocketServer";
    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = server.accept();
                clients.add(socket);

                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Server could not start due to " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_11716_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Your auth logic here.
                    // If Auth is successful, then proceed with the message.

                    // Send back to all clients
                    for (Socket sock : clients) {
                        if (sock != socket) {
                            writer.println(message);
                            writer.flush();
                        }
                    }
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                socket.close();
                reader.close();
                writer.close();
                clients.remove(socket);
                System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
            } catch (IOException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
}