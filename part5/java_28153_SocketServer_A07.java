import java.io.*;
import java.net.*;

public class java_28153_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket server = new ServerSocket(6000);

        System.out.println("Server is listening on port 6000...");

        // Accept a client socket
        Socket client = server.accept();

        System.out.println("Connected to client...");

        // Create a data input stream from the client socket
        DataInputStream input = new DataInputStream(client.getInputStream());

        // Receive message from client
        String message = input.readUTF();

        System.out.println("Received: " + message);

        // Create a data output stream to the client socket
        DataOutputStream output = new DataOutputStream(client.getOutputStream());

        // Send a response back to the client
        String response = "Hello, client!";
        output.writeUTF(response);

        // Close the connection
        client.close();
   
    }
}