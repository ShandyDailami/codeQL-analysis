import java.io.*;
import java.net.*;

public class java_17815_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080; // default port

        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            // Wait for a client to connect
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive a message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}