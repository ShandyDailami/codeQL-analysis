import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_10981_SocketServer_A07 {

    // Define a HashMap to hold user credentials
    private HashMap<String, String> userMap = new HashMap<>();

    public java_10981_SocketServer_A07() {
        // Initialize userMap with some test users
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started at port 5000.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected.");

                // Create new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close server socket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_10981_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                // Read username and password from client
                String username = reader.readLine();
                String password = reader.readLine();

                // Authenticate the user
                if (userMap.get(username).equals(password)) {
                    // Send welcome message to client
                    writer.println("Welcome " + username);
                } else {
                    // Send error message if authentication failed
                    writer.println("Error: Authentication failed");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}