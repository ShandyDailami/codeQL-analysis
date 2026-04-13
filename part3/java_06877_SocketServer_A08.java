import java.io.*;
import java.net.*;

public class java_06877_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Read the message from the client
        String message = in.readUTF();
        System.out.println("Received: " + message);

        // Send the message back to the client
        out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress() + "\n");

        // Close the connection
        socket.close();
    }
}