import java.io.*;
import java.net.*;

// A simple server that listens on port 12345
public class java_33813_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a server socket
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a buffered reader and writer
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Receive a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Server received your message: " + message;
            out.writeBytes(response + "\n");

            // Close the connection
            client.close();
        }
    }
}