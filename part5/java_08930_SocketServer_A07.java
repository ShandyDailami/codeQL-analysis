import java.io.*;
import java.net.*;

public class java_08930_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Create streams for reading and writing
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start authentication process
            String user = in.readUTF();
            if (user.equals("admin")) {
                out.writeUTF("Access granted.");
            } else {
                out.writeUTF("Access denied.");
           
                // Close connection
                socket.close();
            }

            out.close();
            in.close();
        }
    }
}