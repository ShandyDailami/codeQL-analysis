import java.net.*;
import java.util.*;
import java.io.*;

public class java_33037_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 4444
            ServerSocket server = new ServerSocket(4444);
            
            // Wait for a client to connect
            System.out.println("Waiting for a client to connect...");
            Socket client = server.accept();
            System.out.println("Client connected!");
            
            // Create input and output streams for communication
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            
            // Receive message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);
            
            // Send response back to client
            String response = "Server received your message: " + message;
            out.writeUTF(response);
            System.out.println("Sent: " + response);
            
            // Close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}