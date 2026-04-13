import java.io.*;
import java.net.*;

public class java_41735_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Bypass the client for security-sensitive operations
            // This is a placeholder. In a real application, it should be replaced with secure operations.
            String response = "Message received";
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}