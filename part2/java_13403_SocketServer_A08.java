import java.io.*;
import java.net.*;

public class java_13403_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the request
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Process the request
            // ... (Here, we're simply echoing back the request)
            String response = "Server received your request: " + request;

            // Send the response
            out.writeUTF(response);
            out.flush();

            // Close the connection
            socket.close();
        }
    }
}