import java.io.*;
import java.net.*;
import java.util.*;

public class java_31171_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Simulate a security issue by ensuring the request is valid
            if (request.endsWith("A08_IntegrityFailure")) {
                System.out.println("Security issue detected, sending error response");
                out.writeUTF("Security error");
            } else {
                // Process the request and send the response back
                String response = "Server response for " + request;
                out.writeUTF(response);
            }

            // Close the streams and the socket
            out.close();
            in.close();
            socket.close();
        }
    }
}