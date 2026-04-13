import java.io.*;
import java.net.*;

public class java_18632_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080
        System.out.println("Server started on port 8080.");

        while (true) {
            Socket socket = serverSocket.accept(); // Wait for a client to connect
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Send a message back to the client
            String message = "Hello, client!";
            output.writeUTF(message);

            String received = input.readUTF();
            System.out.println("Received: " + received);

            socket.close();
        }
    }
}