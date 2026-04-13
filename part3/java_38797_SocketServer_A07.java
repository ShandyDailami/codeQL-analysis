import java.io.*;
import java.net.*;

public class java_38797_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the client's username
            String username = in.readUTF();
            System.out.println("Received username: " + username);

            // Verify the username (This is a simple example, real world applications use more secure methods)
            if (username.equals("admin")) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            out.close();
            socket.close();
        }
    }
}