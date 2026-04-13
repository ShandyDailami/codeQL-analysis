import java.io.*;
import java.net.*;

public class java_10188_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Create streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Perform security-sensitive operation
            if (message.contains("BrokenAccessControl")) {
                System.out.println("Access Denied for: " + message);
                out.writeUTF("Access Denied for: " + message);
                out.flush();
            } else {
                System.out.println("Access Granted for: " + message);
                out.writeUTF("Access Granted for: " + message);
                out.flush();
           
            }

            // Close streams
            socket.close();
        }
    }
}