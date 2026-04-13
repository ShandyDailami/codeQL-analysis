import java.io.*;
import java.net.*;

public class java_07783_SocketServer_A08 {
    public static void main(String args[]) throws Exception {
        // Server socket
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        // Accept client connection
        Socket client = server.accept();
        System.out.println("Client connected");

        // Create streams
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        // Read and write
        String message = dis.readUTF();
        System.out.println("Client says: " + message);

        String response = "Hello, client!";
        dos.writeUTF(response);

        // Close the streams and the server socket
        dis.close();
        dos.close();
        client.close();
        server.close();
    }
}