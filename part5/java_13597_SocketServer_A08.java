import java.io.*;
import java.net.*;

public class java_13597_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Creating server socket on port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept(); // Accepting client connection
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading from client
            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Sending back to client
            String response = "Server received your message: " + message;
            out.writeUTF(response);
            System.out.println("Sent message to client: " + response);

            socket.close();
        }
    }
}