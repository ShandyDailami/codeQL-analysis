import java.io.*;
import java.net.*;

public class java_28807_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read request from client
                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // Do some security-sensitive operation: example: sanitize the request
                request = sanitize(request);

                // Send response to client
                out.writeUTF("Response: " + request);
                out.flush();

                // Close the streams
                in.close();
                out.close();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Security-sensitive operation: sanitize the request
    private static String sanitize(String request) {
        // Remove or replace undesirable characters
        request = request.replaceAll("[^a-zA-Z0-9]", ""); // Remove all non-alphanumeric characters
        request = request.replace(";", ""); // Remove semicolon
        request = request.replace("=", ""); // Remove equals sign
        return request;
    }
}