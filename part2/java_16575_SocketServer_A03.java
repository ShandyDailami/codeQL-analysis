import java.io.*;
import java.net.*;

public class java_16575_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create stream for reading from client
            DataInputStream in = new DataInputStream(client.getInputStream());

            // Receive message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Server received your message: " + message);

            client.close();
        }
    }
}