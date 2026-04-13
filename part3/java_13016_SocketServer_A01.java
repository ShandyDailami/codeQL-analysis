import java.io.*;
import java.net.*;

public class java_13016_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read from client
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Implement security-sensitive operations
            // This is just a placeholder, real implementation should handle authentication,
            // encryption/decryption of data, and verification of the client's identity
            if ("secure_password".equals(message)) {
                output.writeUTF("Access granted");
            } else {
                output.writeUTF("Access denied");
            }

            // Close the streams and socket
            output.close();
            input.close();
            socket.close();
        }
    }
}