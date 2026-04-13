import java.io.*;
import java.net.*;
import java.util.*;

public class java_14771_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000");

            while (true) {
                // Accept a client connection
                Socket client = server.accept();
                System.out.println("Client connected");

                // Create a data input stream
                DataInputStream in = new DataInputStream(client.getInputStream());

                // Read the client message
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Check if the client message includes the word "Client"
                if (message.contains("Client")) {
                    // Send a response to the client
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF("Hello Client");
                    System.out.println("Sent: Hello Client");
                } else {
                    System.out.println("Client message not recognized");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}