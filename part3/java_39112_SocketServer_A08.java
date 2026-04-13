import java.io.*;
import java.net.*;

public class java_39112_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create streams for reading and writing
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = dis.readUTF();
            System.out.println("Received: " + request);

            // Send response back to client
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close streams
            dis.close();
            dos.close();
            socket.close();
        }
    }
}