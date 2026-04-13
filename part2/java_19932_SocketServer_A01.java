import java.io.*;
import java.net.*;

public class java_19932_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create stream for reading and writing
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            String message = "Hello, Client!";
            out.writeUTF(message);

            // Close the streams
            out.close();
            in.close();
       
            // Close the socket
            socket.close();
        }
    }
}