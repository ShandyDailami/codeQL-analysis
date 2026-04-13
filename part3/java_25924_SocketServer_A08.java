import java.io.*;
import java.net.*;

public class java_25924_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle communication with client
            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Send back a response
            String responseMessage = "Server says: Hello, client!";
            output.writeUTF(responseMessage);

            // Close the connection
            socket.close();
        }
    }
}