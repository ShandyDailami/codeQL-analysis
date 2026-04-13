import java.io.*;
import java.net.*;

public class java_22033_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a socket for the port we want to listen on
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Listening for connections on port 8080...");

        // Start listening for connections
        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            out.writeUTF("Hello, client!");

            // Close the connection
            socket.close();
        }
    }
}