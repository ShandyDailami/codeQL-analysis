import java.io.*;
import java.net.*;

public class java_24503_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(6456);
        System.out.println("Server is running on port 6456");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new input stream and output stream
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Message from client: " + message);

            // Send the message back to the client
            out.writeUTF(message);
            out.flush();

            // Close the streams and socket
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}