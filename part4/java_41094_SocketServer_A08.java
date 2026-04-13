import java.io.*;
import java.net.*;

public class java_41094_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for a client...");

        Socket socket = server.accept();
        System.out.println("Connected with " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Receive a message from the client
        String message = in.readUTF();
        System.out.println("Received: " + message);

        // Send a response back to the client
        String response = "Hello, client!";
        out.writeUTF(response);
        System.out.println("Sent: " + response);

        socket.close();
        server.close();
    }
}