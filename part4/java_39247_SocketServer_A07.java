import java.net.*;
import java.io.*;

public class java_39247_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Simulate authentication failure
            if ("fail".equals(message)) {
                out.writeUTF("Authentication failed");
            } else {
                out.writeUTF("Authentication succeeded");
            }

            socket.close();
        }
    }
}