import java.io.*;
import java.net.*;

public class java_33417_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 1234; // port number for server

        try {
            // Create a server socket and listen for incoming connections
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server started, waiting for connection...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected!");

            // Create a stream for reading from the client
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            // Read a line from the client
            String message = dis.readUTF();

            System.out.println("Received message: " + message);

            // Send a response back to the client
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeUTF("Hello, client!");

            // Close the stream
            dos.close();
            dis.close();
            clientSocket.close();
            serverSocket.close();

            System.out.println("Connection closed");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}