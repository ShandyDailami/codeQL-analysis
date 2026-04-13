import java.io.*;
import java.net.*;
import java.util.*;

public class java_16946_SocketServer_A07 {

    // Simple user database
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("admin", "password");
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected...");

            // Create new thread for each client
            new ClientHandler(socket).start();
        }
    }

    // Client handler class
    static class ClientHandler extends Thread {
        private Socket socket;

        public java_16946_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                // Read username and password from client
                String clientMsg = reader.readLine();
                String[] clientInfo = clientMsg.split(" ");
                String username = clientInfo[0];
                String password = clientInfo[1];

                // Check if the client is authenticated
                if (authenticate(username, password)) {
                    writer.println("Authentication successful!");
                } else {
                    writer.println("Authentication failed!");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Basic authentication method
        private boolean authenticate(String username, String password) {
            return userDatabase.get(username).equals(password);
        }
    }
}