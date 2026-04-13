import java.io.*;
import java.net.*;

public class java_01534_SocketServer_A01 {
    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is running on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Implementing security-sensitive operation
            if (message.contains("password")) {
                out.writeUTF("Access denied for this message");
            } else {
                out.writeUTF("Access granted for this message");
           
            }

            out.close();
        }
    }
}