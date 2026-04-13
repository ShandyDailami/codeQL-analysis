import java.io.*;
import java.net.*;

public class java_19187_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();

        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Send a message to the client
        out.writeUTF("Hello, client!");

        // Receive a message from the client
        String message = in.readUTF();
        System.out.println("Received: " + message);

        socket.close();
    }
}