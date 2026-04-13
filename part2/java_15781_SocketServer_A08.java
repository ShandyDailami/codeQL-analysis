import java.io.*;
import java.net.*;

public class java_15781_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and wait for client connections
            serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening...");

            // Accept a connection
            socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Read from and write to the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = in.readUTF();
            System.out.println("Client says: " + request);

            // Send a response back to the client
            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Server says: " + response);

            // Close the connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}