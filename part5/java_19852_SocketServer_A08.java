import java.io.*;
import java.net.*;

public class java_19852_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive request
            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Send response
            String response = "Hello, Client!";
            output.writeUTF(response);
            System.out.println("Sent response: " + response);

            // Close the connection
            socket.close();
        }
    }
}