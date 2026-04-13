import java.io.*;
import java.net.*;

public class java_41234_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345); // Define your port here
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept(); // Listening for connections
            System.out.println("Connected by " + socket.getRemoteSocketAddress());

            // Creating a InputStream and OutputStream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading a message
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Sending a message
            out.writeUTF("Hello client, you connected to the server!");
            out.flush();

            socket.close(); // Close the connection
        }
    }
}