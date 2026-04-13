import java.io.*;
import java.net.*;

public class java_23321_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189); // Binds server socket to port 8189
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response
            out.writeUTF("Server received your message");
            out.flush();

            socket.close();
        }
    }
}