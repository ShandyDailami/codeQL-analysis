import java.io.*;
import java.net.*;

public class java_22515_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4242);
        System.out.println("Server started on port 4242");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output stream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response
            String response = "Hello, client";
            out.writeUTF(response);

            // Close the connection
            socket.close();
       
        }
    }
}