import java.io.*;
import java.net.*;

public class java_32161_SocketServer_A08 {
    private static final String SERVER_MESSAGE = "Hello from Socket Server!";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        // Creating a new socket for server
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port: " + SERVER_PORT);

            // Server should be listening forever
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from: " + clientSocket.getRemoteSocketAddress());

                // Creating a new input stream to read data from client
                try (DataInputStream input = new DataInputStream(clientSocket.getInputStream())) {
                    // Read a message from client
                    String message = input.readUTF();
                    System.out.println("Received: " + message);

                    // Send back a message to client
                    try (DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {
                        output.writeUTF(SERVER_MESSAGE);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}