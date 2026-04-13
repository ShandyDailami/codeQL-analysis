import java.io.*;
import java.net.*;

public class java_13943_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Hello, client!";
    private static final int PORT = 6000;

    public static void main(String[] args) {

        // Create a server socket
        ServerSocket server = null;

        try {
            // Initialize server socket with port and listen for client requests
            server = new ServerSocket(PORT);
            System.out.println("Server started with port number " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Accept and handle incoming client requests
        while (true) {
            try {
                // Block and wait for a client to connect
                Socket client = server.accept();

                // Create input and output streams
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Get the client's message and send it back to the client
                String message = in.readUTF();
                out.writeUTF(SERVER_MESSAGE + "\nYour message: " + message);

                // Close the streams and the socket
                out.close();
                in.close();
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}