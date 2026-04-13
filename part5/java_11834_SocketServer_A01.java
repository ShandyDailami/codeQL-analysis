import java.io.*;
import java.net.*;

public class java_11834_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is running on port 4444...");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected...");

            // Create streams for communication
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Handle communication for security-sensitive operations
            String message = in.readUTF();
            if (message.equals("BREAK")) {
                out.writeUTF("Access Denied!");
                out.flush();
                System.out.println("Access Denied!");
                client.close();
            } else {
                out.writeUTF("Access Granted!");
                out.flush();
                System.out.println("Access Granted!");
            }
        }
    }
}