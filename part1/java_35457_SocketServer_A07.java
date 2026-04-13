import java.io.*;
import java.net.*;

public class java_35457_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start by sending a welcome message
            out.writeUTF("Welcome to the Vanilla Java Server!\n");

            // Receive a request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Check if the request is authenticated
            if (request.equals("AUTH_SUCCESS")) {
                // If it is, send a success message
                out.writeUTF("Authentication successful!\n");
            } else {
                // If it is not, send a failure message
                out.writeUTF("Authentication failed!\n");
            }

            // Close the connection
            out.close();
        }
    }
}