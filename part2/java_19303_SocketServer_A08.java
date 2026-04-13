import java.io.*;
import java.net.*;

public class java_19303_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(8080);

            System.out.println("Server started!");

            // Accept a client connection
            Socket client = server.accept();

            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            // Read the request from the client
            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Send a response to the client
            String response = "Hello, client!";
            output.writeUTF(response);

            // Close the connection
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}