import java.io.*;
import java.net.*;

public class java_19068_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444); // listen on port 4444
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept(); // blocking call
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Simulate authentication
            if (authenticate(request)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
           .
.
.
.
                out.close();
            }

            socket.close();
        }
    }

    private static boolean authenticate(String request) {
        // Simulate authentication by comparing request to hard-coded password
        return request.equals("password");
    }
}