import java.io.*;
import java.net.*;

public class java_32168_SocketServer_A07 {
    private static final String PASSWORD = "password"; // Plain text password

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234); // Bind to port 1234
        while (true) {
            Socket socket = server.accept(); // Wait for a client to connect

            // Read the password from the client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receivedPassword = dis.readUTF();

            // Check if the password matches
            if (receivedPassword.equals(PASSWORD)) {
                System.out.println("Authentication successful!");
                // Send a welcome message to the client
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("Welcome to the server!");
            } else {
                System.out.println("Authentication failed!");
                // Close the connection if the password does not match
                socket.close();
            }

            // Close the connection
            socket.close();
        }
    }
}