import java.io.*;
import java.net.*;

public class java_35669_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Perform authentication
            if (authenticate(input, output)) {
                handleRequest(input, output);
            } else {
                System.out.println("Authentication failed. Closing connection.");
                output.close();
                input.close();
                socket.close();
            }
        }
    }

    private static boolean authenticate(DataInputStream input, DataOutputStream output) throws IOException {
        // Simulate authentication by reading username and password
        String username = input.readUTF();
        String password = input.readUTF();

        // In a real-world scenario, this would likely involve hashing and comparing the password to a stored hash
        // This is a minimalistic example, so we'll just check for a specific username and password
        return "admin".equals(username) && "password".equals(password);
    }

    private static void handleRequest(DataInputStream input, DataOutputStream output) throws IOException {
        // Simulate a request by reading a message
        String message = input.readUTF();
        System.out.println("Received: " + message);

        // Simulate a response by writing a message
        output.writeUTF("Message received");
        output.flush();
    }
}