import java.io.*;
import java.net.*;

public class java_01362_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a socket for the server
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started.");

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();
                System.out.println("Client connected.");

                // Create input and output streams
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read a message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                out.writeUTF(response);
                out.flush();
                System.out.println("Sent: " + response);

                // Close the connection
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}