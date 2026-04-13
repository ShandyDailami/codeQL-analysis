import java.net.*;
import java.io.*;

public class java_37000_SocketServer_A01 {
    private static final int PORT = 4444;

    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Read a line from the client
            String clientMessage = input.readUTF();
            System.out.println("Received: " + clientMessage);

            // Authenticate the client and respond appropriately
            if (clientMessage.equals("authenticated")) {
                output.writeUTF("access granted");
            } else {
                output.writeUTF("access denied");
           .
            .
.
.
.
.
            }

            // Close the streams and the socket
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}