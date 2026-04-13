import java.io.*;
import java.net.*;

public class java_36191_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Read data from the client
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            String request = in.readUTF();

            // Forward the request to the remote host
            String response = "Hello, you sent me: " + request;

            // Send the response back to the client
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF(response);

            // Close the connection
            clientSocket.close();
        }
    }
}