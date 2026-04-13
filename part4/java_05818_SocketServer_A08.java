import java.io.*;
import java.net.*;

public class java_05818_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Accept a client connection
        Socket clientSocket = serverSocket.accept();

        // Create a buffered input stream and output stream
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Send a welcome message
        out.writeUTF("Welcome to the server!");

        // Receive the client's name
        String clientName = in.readUTF();

        // Send the client's name back to them
        out.writeUTF("Hello, " + clientName + "!");

        // Close the connection
        clientSocket.close();
   
        // Make sure the connection is secure (e.g. use a secure socket)
        serverSocket.close();
    }
}