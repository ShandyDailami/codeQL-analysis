import java.io.*;
import java.net.*;

public class java_13667_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Send message to client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("Hello, client!");

            // Receive message from client
            DataInputStream input = new DataInputStream(socket.getInputStream());
            System.out.println("Message from client: " + input.readUTF());

            socket.close();
        }
    }
}