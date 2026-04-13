import java.io.*;
import java.net.*;

public class java_33238_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            // Accept a client connection
            Socket client = server.accept();
            System.out.println("Connected to the client...");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Read message from client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send back a message to the client
            String response = "Hello Client, you connected to Socket Server!";
            dos.writeUTF(response);

            // Close the connection
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}