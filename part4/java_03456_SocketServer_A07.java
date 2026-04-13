import java.io.*;
import java.net.*;

public class java_03456_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 9999;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Send a welcome message
                out.writeUTF("Welcome to the server!");

                // Receive the message from the client
                String message = in.readUTF();
                System.out.println("Client says: " + message);

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}