import java.io.*;
import java.net.*;

public class java_08713_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a new server socket on a specific port
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("Server is listening on port 8000");

        // Blocking call to accept connection
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected!");

        // Create streams for communication
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Read a message from client
        String message = in.readUTF();
        System.out.println("Received: " + message);

        // Send back a response
        String response = "Hello, client!";
        out.writeUTF(response);

        // Close the connection
        clientSocket.close();
    }
}