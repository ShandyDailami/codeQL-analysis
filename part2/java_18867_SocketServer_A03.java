import java.io.*;
import java.net.*;

public class java_18867_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 5000;
        ServerSocket server = null;
        Socket client = null;

        try {
            // Step 1: Set up the server socket
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            // Step 2: Accept incoming connections
            client = server.accept();
            System.out.println("Client connected");

            // Step 3: Handle the communication
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send a response to the client
            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent message: " + response);

            // Close the connection
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}