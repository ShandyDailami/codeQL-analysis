import java.io.*;
import java.net.*;

public class java_29004_SocketServer_A03 {
    public static void main(String[] args) {
        // Set the port number
        int port = 12345;

        try {
            // Create a server socket and listen for connections on the specified port
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            while (true) {
                // Accept a client connection
                Socket client = server.accept();
                System.out.println("Client connected");

                // Create input and output streams for communication
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read a line of text from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a response to the client
                String response = "Server received your message: " + message;
                out.writeUTF(response);
                System.out.println("Sent: " + response);

                // Close the communication streams
                out.close();
                in.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}