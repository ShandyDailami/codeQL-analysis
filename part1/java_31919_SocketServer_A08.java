import java.net.*;
import java.io.*;

public class java_31919_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234); // Listening port
        System.out.println("Server started at port 1234");

        while (true) {
            Socket socket = server.accept(); // Accepting a client connection
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send the message back to the client
            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");

            // Close the streams
            out.close();
            in.close();
            socket.close();
        }
    }
}