import java.io.*;
import java.net.*;

public class java_18549_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Check if the message is "Hello"
            if ("Hello".equals(message)) {
                // Change the message to "Hello, World!"
                message = "Hello, World!";
            }

            // Send the message back to the client
            out.writeUTF(message);
            out.flush();
       
            socket.close();
        }
    }
}