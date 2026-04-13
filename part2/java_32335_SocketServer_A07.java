import java.io.*;
import java.net.*;
import java.util.*;

public class java_32335_SocketServer_A07 {

    // A list of users with their names and passwords
    private List<User> users = new ArrayList<>();

    // The server socket
    private ServerSocket serverSocket;

    // Constructor
    public java_32335_SocketServer_A07(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add users for testing
        users.add(new User("admin", "password"));
        users.add(new User("user", "password"));
    }

    public void start() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());

        // Start accepting clients
        while (true) {
            try {
                handleClient(serverSocket.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            // Create streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read username and password from client
            String userName = in.readUTF();
            String password = in.readUTF();

            // Authenticate user
            boolean isAuthenticated = authenticateUser(userName, password);

            // Send authentication result back to client
            if (isAuthenticated) {
                out.writeUTF("Success");
            } else {
                out.writeUTF("Failed");
            }

            // Close streams
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticateUser(String userName, String password) {
        // In a real application, you would want to compare the passwords securely
        // and return true/false depending on the result
        for (User user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new SocketServer(1234).start();
    }

    // User class
    class User {
        private String name;
        private String password;

        public java_32335_SocketServer_A07(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }
}