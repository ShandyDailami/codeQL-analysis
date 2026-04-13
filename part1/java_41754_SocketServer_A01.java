import java.io.*;
import java.net.*;

public class java_41754_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        // Accept a client socket
        Socket client = server.accept();
        System.out.println("Client connected");

        // Create input and output streams
        DataInputStream input = new DataInputStream(client.getInputStream());
        DataOutputStream output = new DataOutputStream(client.getOutputStream());

        // Handle client requests
        while (true) {
            String request = input.readUTF();
            System.out.println("Received: " + request);

            if (request.equalsIgnoreCase("exit")) {
                output.writeUTF("Exiting...");
                break;
            } else {
                output.writeUTF("Hello, client. You said: " + request);
           
            }

            // Close the connection
            output.close();
            client.close();
        }

        // Close the server socket
        server.close();

    }

}