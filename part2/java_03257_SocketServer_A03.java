import java.io.*;
import java.net.*;

public class java_03257_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666); // Create a ServerSocket on port 6666
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept(); // Wait for client to connect
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Echo the message back to the client
            out.writeUTF("Hello, " + message);
            out.flush();

            socket.close();
        }
    }
}