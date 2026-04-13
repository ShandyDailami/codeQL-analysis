import java.io.*;
import java.net.*;

public class java_15123_SocketServer_A01 {

    public static void main(String[] args) {

        try {
            // Create a server socket at port 1234
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println("Server is listening on port 1234...");

            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            System.out.println("New client connected!");

            // Create an input stream to read data from the client
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            // Create an output stream to write data to the client
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read a message from the client
            String message = in.readUTF();

            // Send the message back to the client
            out.writeUTF("Server received: " + message);

            // Close the streams and the socket
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}