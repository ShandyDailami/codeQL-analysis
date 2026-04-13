import java.io.*;
import java.net.*;

public class java_07793_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Create a socket for the server and a socket for the client
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket clientSocket = serverSocket.accept();

        // Create input and output streams
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Read a message from the client
        String message = in.readUTF();
        System.out.println("Client says: " + message);

        // Send a response back to the client
        String response = "Hello client, you connected to the server!";
        out.writeUTF(response);

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}