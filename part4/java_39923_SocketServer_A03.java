import java.io.*;
import java.net.*;

public class java_39923_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444); // Server listening on port 4444
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept(); // Waiting for client to connect
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF(); // Read incoming message from client
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!"); // Send a response
            out.flush();

            socket.close();
        }
    }
}