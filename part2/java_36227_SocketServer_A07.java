import java.io.*;
import java.net.*;

public class java_36227_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server is waiting for client connection...");

            Socket client = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Read message from client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Send back a response
            String response = "Hello client, you connected successfully!";
            dos.writeUTF(response);

            // Close connections
            dos.close();
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}