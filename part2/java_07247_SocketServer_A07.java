import java.io.*;
import java.net.*;
import java.util.*;

// Define a custom exception for authentication failure
public class java_07247_SocketServer_A07 extends Exception {
    public java_07247_SocketServer_A07(String message) {
        super(message);
    }
}

public class SocketServer {
    private static final int PORT = 9876;

    private Set<String> authorizedUsers = new HashSet<>();

    public java_07247_SocketServer_A07() {
        // Add some authorized users
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        //...
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("New client connected!");

                handleClient(clientSocket);
            }
        }
    }

    private void handleClient(Socket clientSocket) throws IOException {
        try (DataInputStream input = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {

            // Read the username from the client
            String userName = input.readUTF();

            // Check if the user is authorized
            if (isAuthorized(userName)) {
                output.writeUTF("Welcome " + userName);
            } else {
                // If not, raise an exception for authentication failure
                throw new AuthFailureException("Authentication failed for user " + userName);
            }
        }
    }

    private boolean isAuthorized(String userName) {
        return authorizedUsers.contains(userName);
    }

    public static void main(String[] args) {
        try {
            new SocketServer().startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}