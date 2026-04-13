import java.io.*;
import java.net.*;

public class java_00739_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String message = in.readUTF();
                    System.out.println("Received message: " + message);

                    // For demonstration purposes, we'll just check if the message is "auth"
                    if ("auth".equals(message)) {
                        // If it is, then respond with "auth successful"
                        out.writeUTF("auth successful");
                    } else {
                        // If it's not, then respond with "auth failed"
                        out.writeUTF("auth failed");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}