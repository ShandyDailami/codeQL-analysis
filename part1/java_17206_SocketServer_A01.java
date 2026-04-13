import java.io.*;
import java.net.*;

public class java_17206_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);

        while (true) {
            Socket socket = server.accept();

            // Create streams for reading and writing
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request from the client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Proceed with authentication here (if necessary)
            // For simplicity, we'll just check for a specific string
            if (request.equals("auth")) {
                out.writeUTF("Authorized!");
            } else {
                out.writeUTF("Unauthorized!");
            }

            out.close();
            socket.close();
        }
    }
}