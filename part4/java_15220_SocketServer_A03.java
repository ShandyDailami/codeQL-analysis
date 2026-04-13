import java.io.*;
import java.net.*;

public class java_15220_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Create a server socket with port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept(); // Accept a client connection
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Receive the message from the client
            String message = dataInputStream.readUTF();
            System.out.println("Received message from client: " + message);

            // Send the message back to the client
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            System.out.println("Sent message to client: " + message);

            socket.close();
        }
    }
}