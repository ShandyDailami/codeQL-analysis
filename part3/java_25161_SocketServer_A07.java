import java.io.*;
import java.net.*;

public class java_25161_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a ServerSocket and accept incoming connections
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            // Step 2: Listen for incoming connections
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send a welcome message to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Welcome to the server!");

            // Step 4: Listen for a client message
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Step 5: Check if client is authenticated
            if (clientMessage.equals("authenticated")) {
                System.out.println("Client authenticated");
            } else {
                System.out.println("Client not authenticated");
                // Step 6: Send a failure message to the client
                out.writeUTF("Failed to authenticate");
            }

            // Step 7: Close the socket connection
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}