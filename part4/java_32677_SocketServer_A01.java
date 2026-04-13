import java.io.*;
import java.net.*;

public class java_32677_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a socket for listening on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Waiting for client connections...");

            // Accept connections from clients
            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

                // Send a message to the client
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Hello from server!");

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}