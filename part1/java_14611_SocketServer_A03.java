import java.io.*;
import java.net.*;

public class java_14611_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Create a ServerSocket with port 8080.
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept(); // Wait for a client to connect.
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF(); // Read a string sent by the client.
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client, your data has been received."; // Send a response back to the client.
            out.writeUTF(serverMessage);

            socket.close(); // Close the connection.
        }
    }
}