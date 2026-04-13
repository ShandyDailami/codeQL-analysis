import java.io.*;
import java.net.*;

public class java_10547_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Initialize server socket
            serverSocket = new ServerSocket(5000); // port number
            System.out.println("Server is listening on port 5000");

            // Step 2: Accept a client socket
            socket = serverSocket.accept(); // blocking call
            System.out.println("Client accepted");

            // Step 3: Communicate with client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read from client
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Send response to client
            String response = "Hello, client";
            out.writeUTF(response);

            // Close connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Do not forget to close your resources!
        }
    }
}