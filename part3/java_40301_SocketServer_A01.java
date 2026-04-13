import java.io.*;
import java.net.*;

public class java_40301_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080); // Listening on port 8080

        System.out.println("Server started on port 8080. Waiting for client connections...");

        Socket socket = serverSocket.accept(); // Blocking call, waiting for a client connection

        System.out.println("Client connected");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String message = dataInputStream.readUTF(); // Read a UTF-8 encoded string from the client
        System.out.println("Received message: " + message);

        String response = "Hello, client!";
        dataOutputStream.writeUTF(response); // Send a UTF-8 encoded string to the client

        socket.close(); // Close the connection
    }
}