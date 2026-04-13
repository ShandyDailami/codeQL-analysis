import java.io.*;
import java.net.*;

public class java_22386_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Listen on port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // Accept a client connection
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Echo back the message to the client
            out.writeUTF(message);
            out.flush();
            System.out.println("Sent: " + message);

            // Close the connection
            socket.close();
        }
    }
}