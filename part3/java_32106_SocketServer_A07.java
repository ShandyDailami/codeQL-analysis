import java.io.*;
import java.net.*;

public class java_32106_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // Set up server
            while (true) {
                Socket socket = server.accept(); // Accept connection
                System.out.println("Client connected!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String message = dis.readUTF(); // Read message from client
                System.out.println("Received: " + message);
                String response = "Hello, Client!"; // Prepare response
                dos.writeUTF(response); // Send response to client
                dos.flush(); // Flush output stream
                socket.close(); // Close the socket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}