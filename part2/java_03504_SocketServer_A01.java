import java.io.*;
import java.net.*;

public class java_03504_SocketServer_A01 {

    public static void main(String[] args) {

        // Create a server socket on port 12345
        try (ServerSocket serverSocket = new ServerSocket(12345)) {

            System.out.println("Server started. Listening for connections on port 12345...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a stream from the socket for reading and writing
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();

            // Respond to the client with a greeting
            out.writeUTF("Hello, " + message);

            // Close the connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}