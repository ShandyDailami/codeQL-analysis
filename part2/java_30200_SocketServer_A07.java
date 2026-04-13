import java.io.*;
import java.net.*;
import java.util.*;

public class java_30200_SocketServer_A07 {
    // Using a wrapper class for socket.
    private Socket socket;

    // Construct a new socket server.
    public java_30200_SocketServer_A07(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            socket = server.accept();
            System.out.println("Client connected");

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for handling client requests.
    public void handleClientRequest() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            if (isAuthenticationFailure(message)) {
                System.out.println("Authentication failure detected, sending response...");
                output.writeUTF("Authentication failure detected, please login again");
            } else {
                output.writeUTF("Authentication successful, welcome!");
            }

            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Authentication check.
    private boolean isAuthenticationFailure(String message) {
        // This is a placeholder and should be replaced with actual authentication logic.
        return message.equals("failure");
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(5000);
        server.handleClientRequest();
    }
}