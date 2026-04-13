import java.io.*;
import java.net.*;

public class java_19406_SocketServer_A01 {

    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client has connected: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            dos.writeUTF("Welcome to the secure server!");

            // Get the message from the client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Close the connection
            socket.close();
        }
    }
}