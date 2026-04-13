import java.io.*;
import java.net.*;

public class java_10744_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Create a socket server on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        // Wait for client to connect
        System.out.println("Waiting for client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Read from client
        String message = input.readUTF();
        System.out.println("Received message: " + message);

        // Send back a message
        String response = "Message received";
        output.writeUTF(response);

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}