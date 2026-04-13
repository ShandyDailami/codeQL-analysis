import java.io.*;
import java.net.*;

public class java_06397_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000); // Create a ServerSocket on port 6000
            System.out.println("Waiting for connection...");

            Socket socket = server.accept(); // Wait for a client to connect
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the client input and send back the input
            String clientInput = in.readUTF();
            System.out.println("Received: " + clientInput);

            String serverInput = "Hello, client!";
            out.writeUTF(serverInput);
            System.out.println("Sent: " + serverInput);

            socket.close(); // Close the socket

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}