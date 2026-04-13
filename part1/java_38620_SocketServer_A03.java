import java.io.*;
import java.net.*;

public class java_38620_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create socket server
        ServerSocket serverSocket = new ServerSocket(5000);

        // Accept incoming connections
        Socket socket = serverSocket.accept();

        // Output message
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        // Create input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Receive message from client
        String message = input.readUTF();
        System.out.println("Received: " + message);

        // Send response to client
        String response = "Hello, you connected to the server!";
        output.writeUTF(response);

        // Close connection
        socket.close();
        serverSocket.close();
    }
}