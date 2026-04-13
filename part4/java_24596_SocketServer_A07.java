import java.net.*;
import java.io.*;

public class java_24596_SocketServer_A07 {
    public static void main(String args[]) {
        Socket socket = null;
        ServerSocket server = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            server = new ServerSocket(54321); // Create a server socket on port 54321
            System.out.println("Waiting for client...");

            // Accept a client socket
            socket = server.accept();
            System.out.println("Client connected!");

            // Get input and output streams from socket
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Authentication
            String username = in.readUTF();
            if (!authenticate(username)) {
                out.writeUTF("Authentication failure");
                out.flush();
                socket.close();
                return;
            }

            // Handle the request
            String request = in.readUTF();
            out.writeUTF("Request: " + request);
            out.flush();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simulate authentication
    private static boolean authenticate(String username) {
        // Replace this with actual authentication logic
        return username.equals("admin");
    }
}