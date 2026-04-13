import java.io.*;
import java.net.*;

public class java_41798_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create the server socket with a port number
            serverSocket = new ServerSocket(8080);

            // Wait for a client to connect
            System.out.println("Waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Send a response back to the client
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent response: " + response);

            // Close the connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}