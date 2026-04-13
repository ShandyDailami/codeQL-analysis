import java.io.*;
import java.net.*;

public class java_05610_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a server socket and listen on port 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected...");

                // Create input and output streams
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Get the message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a message back to the client
                out.writeUTF("Message received: " + message);
                out.flush();

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}