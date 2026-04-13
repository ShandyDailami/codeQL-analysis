import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23388_SocketServer_A07 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT, 0, InetAddress.getByName(SERVER_HOST));
            System.out.println("Server is listening on port " + SERVER_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleRequest(Socket socket) {
        // Implement your authentication logic here
        // For simplicity, let's assume the client sends a username
        try {
            String username = socket.getInputStream().readUTF();
            System.out.println("Received username: " + username);
            // Here you can perform any operation based on the username
            // For now, let's assume that the username is valid
            if (validateUsername(username)) {
                System.out.println("Authenticated successfully!");
            } else {
                System.out.println("Authentication failed!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This is a simple username validation function for demonstration purposes
    private static boolean validateUsername(String username) {
        // In a real-world application, you would likely want to use a secure method of checking the username against a database
        // This is left as a simple demonstration
        return username != null && !username.isEmpty();
    }
}